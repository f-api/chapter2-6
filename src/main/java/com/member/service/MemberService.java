package com.member.service;

import com.member.dto.*;
import com.member.entity.Member;
import com.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public CreateMemberResponse createMember(CreateMemberRequest request) {
        Member savedMember = memberRepository.save(new Member(
                request.getName()
        ));
        return new CreateMemberResponse(savedMember.getNickname());
    }

    @Transactional(readOnly = true)
    public List<GetMemberResponse> findAll() {
        List<Member> members = memberRepository.findAll();

        List<GetMemberResponse> dtos = new ArrayList<>();
        for (Member member : members) {
            dtos.add(
                    new GetMemberResponse(
                            member.getId(),
                            member.getNickname()
                    )
            );
        }
        return dtos;
    }

    @Transactional
    public UpdateMemberResponse updateNickname(Long memberId, UpdateMemberRequest request) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalStateException("없는 멤버입니다.")
        );

        member.updateNickname(request.getNickname());
        return new UpdateMemberResponse(
                member.getId(),
                member.getNickname()
        );
    }
}
