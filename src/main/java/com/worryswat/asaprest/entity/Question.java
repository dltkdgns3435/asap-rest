package com.worryswat.asaprest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "question_idx_seq",
        sequenceName = "question_idx"
)
@Entity(name = "question")
public class Question extends Time {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_idx_seq")
    private Long id;

    @Column(length = 500, nullable = false)
    private String content;

    @Column
    private int hits = 0;

    @Column
    private int recommend = 0;

    @Column(length = 20)
    private String nickname;

    @Column(length = 15)
    private String ip;

    @Column
    private LocalDateTime limitTime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<Answer> answers;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<VoteItem> voteItems;

    public void hit() {
        this.hits = this.hits + 1;
    }

    public void recommended() {
        this.recommend = this.recommend + 1;
    }

    @Builder
    public Question(String content, String nickname, String ip, LocalDateTime limitTime, List<Answer> answers, List<VoteItem> voteItems) {
        this.content = content;
        this.nickname = nickname;
        this.ip = ip;
        this.limitTime = limitTime;
        this.answers = answers;
        this.voteItems = voteItems;
    }
}
