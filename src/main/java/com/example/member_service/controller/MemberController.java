package com.example.member_service.controller;


import com.example.member_service.dto.MemberCreateRequest;
import com.example.member_service.dto.MemberDto;
import com.example.member_service.dto.MemberUpdateRequest;
import com.example.member_service.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    final private MemberService memberService;

    @GetMapping("/{memberId}")
    public MemberDto findMember(
            @PathVariable("memberId") Long memberId
    ) {
        return memberService.getMember(memberId);
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
