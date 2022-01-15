package com.worryswat.asaprest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "answer_idx_seq",
        sequenceName = "answer_idx"
)
@Entity(name = "answer")
public class Answer extends Time {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_idx_seq")
    private Long id;

    @Column(length = 500, nullable = false)
    private String content;

    @Column
    private int recommend = 0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 15, nullable = false)
    private String ip;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public void recommended() {
        this.recommend = this.recommend + 1;
    }

    @Builder
    public Answer(String content, int recommend, User user, String ip, Question question) {
        this.content = content;
        this.recommend = recommend;
        this.user = user;
        this.ip = ip;
        this.question = question;
    }
}
