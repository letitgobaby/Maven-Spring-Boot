package com.example.admin.api;

import java.util.Collections;

import com.example.core.model.Member;
import com.example.core.repository.MemberRepo;
import com.example.core.security.JwtTokenProvider;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @Autowired
  MemberRepo memberRepo;

  @PostMapping("/api/member/join")
  public @ResponseBody long join(@RequestBody JSONObject user) {
    return memberRepo.save(
      Member.builder()
        .userId(user.get("username").toString())
        .password(passwordEncoder.encode(user.get("password").toString()))
        .roles(Collections.singletonList("ROLE_USER"))
        .build()
      ).getId();
  }


  @PostMapping("/api/member/login")
  public @ResponseBody JSONObject login(@RequestBody JSONObject user) {
    Member member = memberRepo.findByUserId(user.get("username").toString())
      .orElseThrow(() -> new IllegalArgumentException("없는 아이디입니다."));

    if (!passwordEncoder.matches(user.get("password").toString(), member.getPassword())) {
      throw new IllegalArgumentException("잘못된 비밀번호입니다.");
    }
    
    return jwtTokenProvider.createToken(member.getUserId(), member.getRoles());
  }


  @PostMapping("/api/member/logout")
  public @ResponseBody String logout() {
    return "logout";
  }


  @GetMapping("/api/member/test")
  public @ResponseBody String test() {
    return "TEST !!!";
  }


}
