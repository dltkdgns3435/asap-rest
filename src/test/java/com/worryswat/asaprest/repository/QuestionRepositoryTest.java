package com.worryswat.asaprest.repository;

import com.worryswat.asaprest.domain.question.entity.Question;
import com.worryswat.asaprest.domain.question.query.QuestionSpecification;
import com.worryswat.asaprest.domain.question.repository.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionSpecification questionSpecification;

    private static final String nickname = "테스트닉네임";
    private static final String ip = "255.255.255.255";
    private static final String content = "테스트 큰 질문이 있습니다.";

    @Test
    @DisplayName("질문 생성")
    void save() {
        //given
        Question question = Question.builder()
                .content(content)
                .build();
        //when
        Question result = questionRepository.save(question);

        //then
        assertThat(result).isNotNull();
    }

    void createQuestions(){
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("질문1", null, null, null, null));
        questions.add(new Question("질문2", null, null, null, null));
        questions.add(new Question("질문3", null, null, null, null));
        questions.add(new Question("질문4", null, null, null, null));
        questions.add(new Question("질문5", null, null, null, null));
        //'검색' 키워드 사용
        questions.add(new Question("검색 질문6", null, null, null, null));
        questions.add(new Question("질 검색 문7", null, null, null, null));
        questions.add(new Question("질문 검색 8", null, null, null, null));
        questions.add(new Question("질문9 검색 ", null, null, null, null));
        questions.add(new Question("질문 검색 10", null, null, null, null));
        questionRepository.saveAll(questions);
    }

    @Test
    @DisplayName("질문 검색어로 조회")
    void read_by_search(){
        //given
        createQuestions();

        //when
        List<Question> result = questionRepository.findAll(questionSpecification.searchByContent("검색"));

        //then
        assertThat(result.size()).isEqualTo(5);
    }

}