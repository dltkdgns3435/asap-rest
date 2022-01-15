package com.worryswat.asaprest.domain.question.entity;

import com.worryswat.asaprest.domain.common.entity.Time;
import com.worryswat.asaprest.domain.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "vote_item_idx_seq",
        sequenceName = "vote_item_idx"
)
@Entity(name = "vote_item")
public class VoteItem extends Time {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_item_idx_seq")
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
