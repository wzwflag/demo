<%--
  Created by IntelliJ IDEA.
  User: wu'zhong'wen
  Date: 2023/3/2
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>菜鸟教程(runoob.com)</title>
</head>

<style type="text/css">

    #container{
        width: 100%;
        padding: 50px;
        box-sizing: border-box;
    }
    #process{
        width: 100%;
        height: 60px;
        background: rgba(196, 18, 18, 0.47);
        position: relative;
    }
    #wrap{
        height: 60px;
        background: #1589e2;
    }
</style>
<body>

<h2>include 动作实例fdasfa</h2>
<h3>${msg}</h3>

<div id="container">
    <div id="process">
        <div id="wrap"></div>
    </div>
</div>
<span id="timespan">

</span>

</body>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script>
    var a = $("#process");
    var b = $("#timespan");
    var c = $("#wrap")
    a.mousemove(function (e){
        console.log(e.offsetX);
        b.html(e.offsetX);
        c.width(e.offsetX);
    });
</script>
</html>