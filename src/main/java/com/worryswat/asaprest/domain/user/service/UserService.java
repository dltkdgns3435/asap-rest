package com.worryswat.asaprest.domain.user.service;

import com.worryswat.asaprest.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    //유저 생성
    //유저 닉네임 조회
    //유저 로그인

    public Long createUser(){
        return 0L;
    }
}
