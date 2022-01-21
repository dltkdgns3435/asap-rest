package com.worryswat.asaprest.domain.question.dto;

import com.worryswat.asaprest.domain.player.entity.Player;
import com.worryswat.asaprest.domain.question.entity.Answer;
import com.worryswat.asaprest.domain.question.entity.Question;
import com.worryswat.asaprest.domain.question.entity.VoteItem;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@AllArgsConstructor
public class PostQuestionDto {
    @NotEmpty(message = "질문 내용을 입력해 주세요.")
    private String content;

    private boolean isAnswer;

    private boolean isVote;

    private LocalDateTime limitTime;

    public Question toEntity() {
        return Question.builder()
                .content(content)
                .answers(isAnswer ? new ArrayList<>() : null)
                .voteItems(isVote ? new ArrayList<>() : null)
                .limitTime(limitTime)
                .build();
    }

}
