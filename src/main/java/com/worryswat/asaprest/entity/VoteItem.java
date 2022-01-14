package com.worryswat.asaprest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vote_item")
public class VoteItem extends Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(length = 10, nullable = false)
    private String title;

    @Column
    private int voteCount = 0;

    public void voted() {
        this.voteCount = this.voteCount + 1;
    }

    @Builder
    public VoteItem(Question question, String title) {
        this.question = question;
        this.title = title;
    }
}
