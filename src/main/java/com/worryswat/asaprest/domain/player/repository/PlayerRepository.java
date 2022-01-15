package com.worryswat.asaprest.domain.player.repository;

import com.worryswat.asaprest.domain.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findById(Long id);
    Optional<Player> findByNickname(String nickname);
}
