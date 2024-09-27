package com.example.member_service.dto;


import com.example.member_service.entity.MemberEntity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.lang.reflect.Member;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class MemberCreateRequest {

    @NotNull
    private String nickName;

    @NotNull
    private LocalDateTime createdAt;


}
