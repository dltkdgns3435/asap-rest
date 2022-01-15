package com.worryswat.asaprest.domain.player.service;

import com.worryswat.asaprest.domain.player.dto.LoginPlayerDto;
import com.worryswat.asaprest.domain.player.entity.Player;
import com.worryswat.asaprest.domain.player.repository.PlayerRepository;
import com.worryswat.asaprest.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final PlayerRepository playerRepository;
    private final JwtTokenProvider tokenProvider;

    public String login(LoginPlayerDto loginPlayerDto){
        Player player = playerRepository.findByNickname(loginPlayerDto.getNickname())
                .orElseThrow(() ->new IllegalStateException("아이디 불일치"));
        validPassword(player, loginPlayerDto.getPassword());
        return tokenProvider.generateToken(player.getNickname());
    }

    private void validPassword(Player player, String password){
        if(!player.getPassword().equals(password)) throw new IllegalStateException("비밀번호 불일치");
    }

}
