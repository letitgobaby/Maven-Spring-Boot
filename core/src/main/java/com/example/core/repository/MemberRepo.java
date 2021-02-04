package com.example.core.repository;

import java.util.Optional;

import com.example.core.model.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {
  Optional<Member> findByUserId(String userId);
  
}
