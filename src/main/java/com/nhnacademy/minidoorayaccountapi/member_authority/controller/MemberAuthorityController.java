package com.nhnacademy.minidoorayaccountapi.member_authority.controller;

import com.nhnacademy.minidoorayaccountapi.exception.NotFoundMemberException;
import com.nhnacademy.minidoorayaccountapi.member.repository.MemberRepository;
import com.nhnacademy.minidoorayaccountapi.member_authority.dto.MemberAuthorityDto;
import com.nhnacademy.minidoorayaccountapi.member_authority.entity.MemberAuthority;
import com.nhnacademy.minidoorayaccountapi.member_authority.service.MemberAuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members/{member-id}/authority")
@RequiredArgsConstructor
public class MemberAuthorityController {
    private final MemberRepository memberRepository;
    private final MemberAuthorityService memberAuthorityService;
    @GetMapping
    public ResponseEntity<MemberAuthorityDto> getMemberAuthority(@PathVariable("member-id") String memberId) {
        MemberAuthority memberAuthority = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundMemberException(memberId))
                .getMemberAuthority();
        return ResponseEntity.ok(memberAuthorityService.getMemberAuthority(memberAuthority.getMemberAuthorityId()));
    }

    @PutMapping
    public ResponseEntity<Void> updateMemberAuthority(@PathVariable("member-id") String memberId,
                                                      @RequestBody MemberAuthorityDto memberAuthorityDto) {
        MemberAuthority memberAuthority = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundMemberException(memberId))
                .getMemberAuthority();
        memberAuthorityService.updateMemberAuthority(memberAuthority.getMemberAuthorityId(), memberAuthorityDto);
        return ResponseEntity.ok().build();
    }
}