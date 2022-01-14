package com.worryswat.asaprest.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class QuestionTest {

    @Test
    void hit() {
        //given
        Question question = Question.builder()
                .content("질문입니다")
                .nickname("닉네임")
                .ip("255.255.255.255")
                .build();

        //when
        question.hit();

        //then
        assertThat(question.getHits()).isEqualTo(1);
    }

    @Test
    void recommended() {
        //given
        Question question = Question.builder()
                .content("질문입니다")
                .nickname("닉네임")
                .ip("255.255.255.255")
                .build();

        //when
        question.recommended();

        //then
        assertThat(question.getRecommend()).isEqualTo(1);
    }
}