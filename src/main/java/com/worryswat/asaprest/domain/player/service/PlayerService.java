package com.worryswat.asaprest.domain.player.service;

import com.worryswat.asaprest.domain.player.dto.LoginPlayerDto;
import com.worryswat.asaprest.domain.player.dto.PlayerIdPasswordDto;
import com.worryswat.asaprest.domain.player.entity.Player;
import com.worryswat.asaprest.domain.player.repository.PlayerRepository;
import com.worryswat.asaprest.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final JwtTokenProvider tokenProvider;

    //사용자 로그인/회원가입 통합
    public String login(PlayerIdPasswordDto postPlayerDto){
        //ID로 플레이어를 조회하고, 존재하면 로그인 진행, 존재하지 않으면 회원가입 후 로그인을 진행한다.
        Player player = playerRepository.findByNickname(postPlayerDto.getNickname())
                .orElseGet(() -> createUser(postPlayerDto));

        validPassword(player, postPlayerDto.getPassword());
        return tokenProvider.generateToken(player.getNickname());
    }

    //사용자 로그인시 비밀번호 검증
    private void validPassword(Player player, String password){
        if(!player.getPassword().equals(password)) throw new IllegalStateException("비밀번호 불일치");
    }

    //사용자 회원가입
    private Player createUser(PlayerIdPasswordDto postPlayerDto){
        return playerRepository.save(postPlayerDto.toEntity());
    }


}
