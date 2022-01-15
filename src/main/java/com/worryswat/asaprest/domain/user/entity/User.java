package com.worryswat.asaprest.domain.user.entity;


import com.worryswat.asaprest.domain.question.entity.Answer;
import com.worryswat.asaprest.domain.question.entity.Question;
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
        name = "user_idx_seq",
        sequenceName = "user_idx"
)
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_idx_seq")
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, length = 256)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Question> questions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Answer> answers;

    @Builder
    public User(String nickname, String password, List<Question> questions, List<Answer> answers) {
        this.nickname = nickname;
        this.password = password;
        this.questions = questions;
        this.answers = answers;
    }
}
