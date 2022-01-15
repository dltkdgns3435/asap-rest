package com.worryswat.asaprest.domain.player.service;

import com.worryswat.asaprest.domain.player.dto.PostPlayerDto;
import com.worryswat.asaprest.domain.player.entity.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PlayerServiceTest {
    @Autowired
    private PlayerService playerService;

    @Test
    void createPlayer(){
        //given
        PostPlayerDto postPlayerDto = new PostPlayerDto("테스트", "1234");

        //when
        Long id = playerService.createUser(postPlayerDto);

        //then
        assertThat(id).isNotNull();
    }

}