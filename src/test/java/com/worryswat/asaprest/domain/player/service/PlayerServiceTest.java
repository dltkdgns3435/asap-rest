package com.worryswat.asaprest.domain.player.service;

import com.worryswat.asaprest.domain.player.dto.PlayerIdPasswordDto;
import com.worryswat.asaprest.domain.player.entity.Player;
import com.worryswat.asaprest.domain.player.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlayerServiceTest {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    @BeforeAll
    void createAccount(){
        Player player = Player.builder()
                .nickname("닉네임")
                .password("1234")
                .build();
        playerRepository.save(player);
    }

    @Test
    void login(){
        //given
        PlayerIdPasswordDto playerIdPasswordDto = new PlayerIdPasswordDto("닉네임", "1234");

        //when
        String token = playerService.login(playerIdPasswordDto);

        //then
        assertThat(token).isNotNull();
        System.out.println("token = " + token);

    }

    @Test
    void login_fail(){
        //given
        PlayerIdPasswordDto playerIdPasswordDto = new PlayerIdPasswordDto("닉네임", "4321");

        //when
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> playerService.login(playerIdPasswordDto));

        //then
        assertThat(e.getMessage()).isEqualTo("비밀번호 불일치");

    }

    @Test
    void login_post(){
        //given
        PlayerIdPasswordDto playerIdPasswordDto = new PlayerIdPasswordDto("신규닉네임", "1234");

        //when
        String token = playerService.login(playerIdPasswordDto);

        //then
        assertThat(token).isNotNull();
        System.out.println("token = " + token);

    }
}