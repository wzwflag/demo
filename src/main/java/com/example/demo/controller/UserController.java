package com.example.demo.controller;

import com.example.demo.common.UserService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class UserController
{
    @Autowired
    UserService userService;

    private static String algorithm = "SHA-512";

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam(defaultValue = "12345") Long name,
                        @RequestParam(defaultValue = "admin") String psw,
                                    HttpServletResponse response)
    {
        String salt = ":::SALT";
        String sha = getSha(psw + name + salt, algorithm, salt);


        User u = new User();
        u.setId(name);
        u.setPsw(psw);
        User i = userService.getById(name);

        if(i != null && sha.equals(i.getPsw())){

        }
        Cookie token = new Cookie("U_token", sha);
        token.setMaxAge(15 * 24 * 60 * 60 );
        token.setDomain("localhost");

        response.addCookie(token);
        return sha;
    }

//    @RequestMapping("/doLogin")
//    @ResponseBody
//    public SysResult doLogin(User user, HttpServletResponse response){
//
//        //1.实现用户的登录操作!!!
//        String ticket = dubboUserService.doLogin(user);
//        //2.校验ticket是否有值.
//        if(StringUtils.isEmpty(ticket)){
//            //用户名或者密码错误
//            return SysResult.fail();
//        }
//        //3.如果用户的ticket不为null,则表示登录正确,需要将数据保存到cookie中
//        //Cookie要求   1.7天有效  2.要求cookie可以在jt.com的域名中共享  3.cookie权限 /
//        Cookie cookie = new Cookie("JT_TICKET",ticket);
//        cookie.setMaxAge(7*24*3600);
//        cookie.setDomain("jt.com"); //在jt.com中实现页面共享.
//        cookie.setPath("/");        //定于cookie的权限根目录有效
//        response.addCookie(cookie); //利用response将cookie保存到客户端中.
//        return SysResult.success();
//    }


    private String getSha(String plainText, String algorithm, String salt)
    {
        //输入的字符串转换成字节数组
        plainText = String.join(plainText, salt);
        byte[] bytes = plainText.getBytes(StandardCharsets.UTF_8);
        MessageDigest messageDigest;
        try {
            //获得SHA转换器
            messageDigest = MessageDigest.getInstance(algorithm);
            //bytes是输入字符串转换得到的字节数组
            messageDigest.update(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA签名过程中出现错误,算法异常");
        }
        //转换并返回结果，也是字节数组，包含16个元素
        byte[] digest = messageDigest.digest();
        //字符数组转换成字符串返回
        return byteArrayToHexString(digest);
    }

    private String byteArrayToHexString(byte[] bytes)
    {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            //java.lang.Integer.toHexString() 方法的参数是int(32位)类型，
            //如果输入一个byte(8位)类型的数字，这个方法会把这个数字的高24为也看作有效位，就会出现错误
            //如果使用& 0XFF操作，可以把高24位置0以避免这样错误
            String temp = Integer.toHexString(b & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                builder.append("0");
            }
            builder.append(temp);
        }
        return builder.toString();
    }
}
