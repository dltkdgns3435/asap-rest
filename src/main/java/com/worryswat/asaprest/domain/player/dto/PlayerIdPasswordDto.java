package com.worryswat.asaprest.domain.player.dto;

import com.worryswat.asaprest.domain.player.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class PlayerIdPasswordDto {
    @NotEmpty(message = "닉네임을 입력해주세요")
    private String nickname;
    @NotEmpty(message = "패스워드를 입력해주세요")
    private String password;

    public Player toEntity(){
        return Player.builder().nickname(nickname).password(password).build();
    }
}
