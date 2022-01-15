package com.worryswat.asaprest.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AnswerTest {
    @Test
    @DisplayName("답변 추천")
    void recommended() {
        //given
        Answer answer = Answer.builder()
                .content("질문이에요")
                .build();

        //when
        answer.recommended();

        //then
        assertThat(answer.getRecommend()).isEqualTo(1);
    }
}