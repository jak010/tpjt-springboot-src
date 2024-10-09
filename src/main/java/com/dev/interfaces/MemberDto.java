package com.dev.interfaces;

import com.dev.domain.member.MemberCommand;
import com.dev.domain.member.MemberInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class MemberDto {


    @Getter
    @Setter
    @ToString
    public static class RegsiterMemberRequest {

        private String nickName;

        public MemberCommand toCommand() {
            return MemberCommand.builder()
                    .nickName(nickName)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class RegisterResponse {

        private final String nickName;
        private final String grade;

        public RegisterResponse(MemberInfo memberInfo) {

            this.nickName = memberInfo.getNickName();
            this.grade = memberInfo.getGrade().name();
        }

    }

}
