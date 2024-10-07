package com.dev.interfaces;


import com.dev.domain.member.MemberInfo;
import com.dev.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/members")
public class MemberApiAController {

    private final MemberService memberService;

    @PostMapping
    public MemberInfo registerMember(@RequestBody MemberDto.RegsiterMemberRequest request) {
        var command = request.toCommand();
        var memberInfo = memberService.registerMember(command);
        return memberInfo;
    }


    @GetMapping("/{memberId}")
    public MemberInfo getMember(@PathVariable("memberId") Long memberId) {
        var memberInfo = memberService.getMember(memberId);
        return memberInfo;

    }

}
