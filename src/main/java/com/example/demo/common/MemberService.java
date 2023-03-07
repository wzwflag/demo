package com.example.demo.common;

import com.example.demo.entity.Member;
import com.example.demo.entity.User;

import java.util.List;

public interface MemberService {

     int add(Member member);

     int delete(Long memberId);

     int update(Member member);

     int searchById(Long memberId);

     List<Member> find();
}
