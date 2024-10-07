package com.dev.domain.member;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {


    private final MemberWriter memberWriter;
    private final MemberReader memberReader;

    @Override
    @Transactional
    public MemberInfo registerMember(MemberCommand command) {

        var initMember = command.toEntity();
        Member member = memberWriter.saveMember(initMember);
        return new MemberInfo(member);

    }

    @Override
    public MemberInfo getMember(Long memberId) {
        var member = memberReader.getMember(memberId);
        return new MemberInfo(member);
    }


}
