package com.example.member_service.service;


import com.example.member_service.dto.MemberCreateRequest;
import com.example.member_service.dto.MemberDto;
import com.example.member_service.dto.MemberPagingRequest;
import com.example.member_service.dto.MemberUpdateRequest;
import com.example.member_service.entity.MemberEntity;
import com.example.member_service.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    /**
     * JPA - READ
     */
    public MemberDto getMember(Long memberId) {
        // SELECT * FROM Member WHERE member = :memberid;
        MemberEntity memberEntity = memberRepository.findByMemberId(memberId);
        return MemberDto.builder()
                .memberId(memberEntity.getMemberId())
                .build();
    }

    public List<MemberDto> getMembersByIds(List<Long> memberIds) {
        // SELECT * FROM Member WHERE member_id IN :memberIds
        List<MemberDto> members = new ArrayList<>();
        for (MemberEntity member : memberRepository.findAllByMemberIdIn(memberIds)) {
            members.add(
                    MemberDto.builder()
                            .memberId(member.getMemberId())
                            .createdAt(member.getCreatedAt())
                            .updateAt(member.getUpdatedAt())
                            .build()
            );
        }
        return members;
    }

    public Page<MemberEntity> findMembers(
            MemberPagingRequest memberPagingRequest,
            Pageable pageable
    ) {
        Page<MemberEntity> pageResult = memberRepository.findAll(pageable);
        return pageResult;
    }


    /**
     * JPA - CREATE
     */
    @Transactional
    public MemberDto saveMember(MemberCreateRequest memberCreateRequest) {
        // INSERT INTO Member VALUES ...;
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
        // UPDATE SET Member ....
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
