package com.example.web.dto;

import com.example.domain.entity.Member;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MemberDto {
    String name;
    String mail;

    public MemberDto(Member member) {
        if (member.getName() != null) {
            this.name = member.getName().toUpperCase();
            this.mail = member.getUserId() + "@joins.com";
        }
    }
}
