package com.worryswat.asaprest.domain.player.controller;

import com.worryswat.asaprest.domain.player.dto.PlayerIdPasswordDto;
import com.worryswat.asaprest.domain.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/player")
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping("/login")
    public ResponseEntity<String> loginPlayer(PlayerIdPasswordDto playerIdPasswordDto){
        String result = playerService.login(playerIdPasswordDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
