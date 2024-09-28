package com.example.member_service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@RequiredArgsConstructor
public class MemberDto {

    final private Long memberId;
    final private String nickName;

    final private LocalDateTime createdAt;

}
