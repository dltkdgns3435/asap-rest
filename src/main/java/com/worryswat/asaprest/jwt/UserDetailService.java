package com.worryswat.asaprest.jwt;

import com.worryswat.asaprest.domain.player.entity.Player;
import com.worryswat.asaprest.domain.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final PlayerRepository playerRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String stringId) throws UsernameNotFoundException {
        Long id = Long.parseLong(stringId);
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        return new User(player.getNickname(), player.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_PLAYER")));
    }

}
