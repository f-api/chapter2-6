package com.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateMemberRequest {

    @NotBlank
    private String name;
}
