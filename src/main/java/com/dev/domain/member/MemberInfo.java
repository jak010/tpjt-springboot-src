package com.dev.domain.member;

import lombok.Getter;

import java.time.ZonedDateTime;


@Getter
public class MemberInfo {

    private final String nickName;
    private final Member.Grade grade;

    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;


    public MemberInfo(Member member) {
        this.nickName = member.getNickName();
        this.grade = member.getGrade();
        this.createdAt = member.getCreatedAt();
        this.updatedAt = member.getUpdatedAt();
    }
}
