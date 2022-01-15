package com.worryswat.asaprest.domain.player.service;

import com.worryswat.asaprest.domain.player.dto.PostPlayerDto;
import com.worryswat.asaprest.domain.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public Long createUser(PostPlayerDto postPlayerDto){
        return playerRepository.save(postPlayerDto.toEntity()).getId();
    }
}
