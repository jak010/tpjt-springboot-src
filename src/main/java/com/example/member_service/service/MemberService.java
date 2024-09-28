package com.example.member_service.service;


import com.example.member_service.dto.MemberCreateRequest;
import com.example.member_service.dto.MemberDto;
import com.example.member_service.dto.MemberUpdateRequest;
import com.example.member_service.entity.MemberEntity;
import com.example.member_service.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.function.array.ArraySliceUnnestFunction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    /**
     * JPA - READ
     */
    public MemberDto getMember(Long memberId) {
        MemberEntity memberEntity = memberRepository.findByMemberId(memberId);
        return MemberDto.builder()
                .memberId(memberEntity.getMemberId())
                .build();
    }

    public List<MemberDto> getMembersByIds(List<Long> memberIds) {

        List<MemberDto> members = new ArrayList<>();
        for (MemberEntity member : memberRepository.findAllByMemberIdIn(memberIds)) {
            members.add(
                    MemberDto.builder()
                            .memberId(member.getMemberId())
                            .build()
            );
        }
        return members;
    }


    /**
     * JPA - CREATE
     */
    @Transactional
    public MemberDto saveMember(MemberCreateRequest memberCreateRequest) {
        /* Create */
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickName(memberCreateRequest.getNickName());
        memberEntity.setCreatedAt(memberEntity.getCreatedAt());

        MemberEntity savedMember = memberRepository.save(memberEntity);

        return MemberDto.builder()
                .memberId(savedMember.getMemberId())
                .nickName(savedMember.getNickName())
                .build();
    }

    /**
     * JPA - UPDATE
     */
    @Transactional
    public void updateMember(
            Long memberId,
            MemberUpdateRequest memberUpdateRequest
    ) {
        MemberEntity memberEntity = memberRepository.findByMemberId(memberId);

        memberEntity.setNickName(memberUpdateRequest.getNickName());

        memberRepository.save(memberEntity);


    }

    /**
     * JPA - DELETE
     */
    @Transactional
    public void deleteMember(Long memberId) {
        memberRepository.deleteByMemberId(memberId);
    }
}
