package com.worryswat.asaprest.domain.player.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class LoginPlayerDto {
    @NotEmpty(message = "닉네임을 입력해주세요")
    private String nickname;
    @NotEmpty(message = "패스워드를 입력해주세요")
    private String password;

}
