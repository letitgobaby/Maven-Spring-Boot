package com.example.core.service;

import com.example.core.repository.MemberRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements UserDetailsService {

  private final MemberRepo memberRepo;

  public MemberService(MemberRepo repo) {
    this.memberRepo = repo;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return memberRepo.findByUserId(username)
      .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
  }
  
  
}
