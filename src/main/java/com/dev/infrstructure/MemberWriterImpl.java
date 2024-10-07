package com.dev.infrstructure;

import com.dev.domain.member.Member;
import com.dev.domain.member.MemberWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberWriterImpl implements MemberWriter {

    private final MemberRepository memberRepository;


    @Override
    public Member saveMember(Member initMember) {
        return memberRepository.save(initMember);
    }
}
