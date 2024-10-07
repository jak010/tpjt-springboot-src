package com.dev.infrstructure;

import com.dev.domain.member.Member;
import com.dev.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberReaderImpl implements MemberReader {

    private final MemberRepository memberRepository;


    @Override
    public Member getMember(Long memberId) {
        return memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new RuntimeException("Not Exist Member"));

    }
}
