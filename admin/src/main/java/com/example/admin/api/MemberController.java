package com.example.admin.api;

import java.util.Collections;

import com.example.core.model.Member;
import com.example.core.repository.MemberRepo;
import com.example.core.security.JwtTokenProvider;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @Autowired
  MemberRepo memberRepo;

  @PostMapping("/test/join")
  public @ResponseBody long join(@RequestBody JSONObject user) {
    return memberRepo.save(
      Member.builder()
        .userId(user.get("userid").toString())
        .password(passwordEncoder.encode(user.get("password").toString()))
        .roles(Collections.singletonList("ROLE_USER"))
        .build()
      ).getId();
  }

  @PostMapping("/test/login")
  public @ResponseBody String login(@RequestBody JSONObject user) {
    Member member = memberRepo.findByUserId(user.get("userid").toString())
      .orElseThrow(() -> new IllegalArgumentException("없는 아이디입니다."));

    if (!passwordEncoder.matches(user.get("password").toString(), member.getPassword())) {
      throw new IllegalArgumentException("잘못된 비밀번호입니다.");
    }
    
    return jwtTokenProvider.createToken(member.getUserId(), member.getRoles());
  }

}
