package com.worryswat.asaprest.domain.player.service;

import com.worryswat.asaprest.domain.player.dto.LoginPlayerDto;
import com.worryswat.asaprest.domain.player.entity.Player;
import com.worryswat.asaprest.domain.player.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountServiceTest {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    AccountService accountService;

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
        LoginPlayerDto loginPlayerDto = new LoginPlayerDto("닉네임", "1234");
        
        //when
        String token = accountService.login(loginPlayerDto);
        
        //then
        assertThat(token).isNotNull();
        System.out.println("token = " + token);
        
    }
    


}