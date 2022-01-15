package com.worryswat.asaprest.entity;

import com.worryswat.asaprest.domain.question.entity.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class QuestionTest {

    @Test
    @DisplayName("질문 조회")
    void hit() {
        //given
        Question question = Question.builder()
                .content("질문입니다")
                .build();

        //when
        question.hit();

        //then
        assertThat(question.getHits()).isEqualTo(1);
    }

    @Test
    @DisplayName("질문 추천")
    void recommended() {
        //given
        Question question = Question.builder()
                .content("질문입니다")
                .build();

        //when
        question.recommended();

        //then
        assertThat(question.getRecommend()).isEqualTo(1);
    }
}