package com.dev.domain.member;

public interface MemberService {

    MemberInfo registerMember(MemberCommand command);

    MemberInfo getMember(Long memberId);

}
