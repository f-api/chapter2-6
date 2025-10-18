package com.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickname;

    public Member(String name) {
        this.name = name;
        this.nickname = UUID.randomUUID().toString();
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }
}
