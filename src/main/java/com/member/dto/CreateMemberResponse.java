package com.member.dto;

import lombok.Getter;

@Getter
public class CreateMemberResponse {

    private final String nickname;

    public CreateMemberResponse(String nickname) {
        this.nickname = nickname;
    }
}
