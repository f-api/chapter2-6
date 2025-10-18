package com.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateMemberRequest {

    @NotBlank
    private String nickname;
}
