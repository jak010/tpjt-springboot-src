package com.dev.infrastructure.member;

import com.dev.common.exception.EntityNotFoundException;
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
                .orElseThrow(() -> new EntityNotFoundException("Member를 찾을 수 없음"));

    }
}
