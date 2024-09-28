package com.example.member_service.controller;


import com.example.member_service.dto.MemberCreateRequest;
import com.example.member_service.dto.MemberDto;
import com.example.member_service.dto.MemberPagingRequest;
import com.example.member_service.dto.MemberUpdateRequest;
import com.example.member_service.entity.MemberEntity;
import com.example.member_service.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public MemberDto findMember(
            @PathVariable("memberId") Long memberId
    ) {
        return memberService.getMember(memberId);
    }

    @GetMapping("/member-ids")
    public List<MemberDto> findMembers(
            @RequestParam("member_id") List<Long> memberIds
    ) {
        return memberService.getMembersByIds(memberIds);
    }

    @GetMapping("/")
    public Page<MemberEntity> findMemberWithPage(

            @ParameterObject MemberPagingRequest memberPagingRequest, // @ParameterObject : Swagger UI에서 Query Parameter가 하나의 Object로 받는 걸 각각의 parameter로 분리해준다.
            @ParameterObject Pageable page
    ) {
        Page<MemberEntity> memberEntities = memberService.findMembers(memberPagingRequest, page);

        return memberEntities;
    }


    @PostMapping
    public MemberDto saveMember(
            @RequestBody MemberCreateRequest memberCreateRequest // xxx: Post 요청에서 입력받는 데이터는 "Request" 객체로 ?
    ) {
        return memberService.saveMember(memberCreateRequest);
    }

    @PutMapping("/{memberId}")
    public void updateMember(
            @PathVariable("memberId") Long memberId,
            @RequestBody MemberUpdateRequest memberUpdateRequest
    ) {
        memberService.updateMember(memberId, memberUpdateRequest);
    }

    @DeleteMapping("/{memberId}")
    public void deleteMembere(
            @PathVariable("memberId") Long memberId
    ) {
        memberService.deleteMember(memberId);
    }


}
