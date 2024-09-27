package com.example.member_service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class MemberDto {

    final private Long memberId;
    final private String nickName;


}
