package com.member.dto;

import lombok.Getter;

@Getter
public class GetMemberResponse {

    private final Long id;
    private final String nickname;

    public GetMemberResponse(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
