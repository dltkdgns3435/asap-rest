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
        name = "user_idx_seq",
        sequenceName = "user_idx"
)
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_idx_seq")
    private Long id;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 15, nullable = false)
    private String ip;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Question> questions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Answer> answers;

    @Builder
    public User(String nickname, String ip, List<Question> questions, List<Answer> answers) {
        this.nickname = nickname;
        this.ip = ip;
        this.questions = questions;
        this.answers = answers;
    }
}
