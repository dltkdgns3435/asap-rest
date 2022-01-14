package com.worryswat.asaprest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "answer")
public class Answer extends Time{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String content;

    @Column
    private int up;

    @Column
    private int down;

    @Column(length = 20)
    private String nickname;

    @Column(length = 15)
    private String ip;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

}
