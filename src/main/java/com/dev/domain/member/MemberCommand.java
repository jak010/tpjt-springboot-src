package com.dev.domain.member;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Command 객체는 Create, Update, Delete를 수행한다.
 */
@Getter
@Builder
@ToString
public class MemberCommand {

    private String nickName;

    public Member toEntity() {
        return Member.builder()
                .nickName(nickName)
                .build();
    }
}
