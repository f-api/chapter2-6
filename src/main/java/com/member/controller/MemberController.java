package com.member.controller;

import com.member.dto.*;
import com.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<CreateMemberResponse> createMember(
            @RequestBody CreateMemberRequest request
    ) {
        CreateMemberResponse result = memberService.createMember(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/members")
    public ResponseEntity<List<GetMemberResponse>> getMembers() {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findAll());
    }

    @PatchMapping("/members/{memberId}")
    public ResponseEntity<UpdateMemberResponse> updateMemberNickname(
            @PathVariable Long memberId,
            @RequestBody UpdateMemberRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.updateNickname(memberId, request));
    }
}
