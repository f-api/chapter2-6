package com.member.dto;

import lombok.Getter;

@Getter
public class UpdateMemberResponse {

    private final Long id;
    private final String nickname;

    public UpdateMemberResponse(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
