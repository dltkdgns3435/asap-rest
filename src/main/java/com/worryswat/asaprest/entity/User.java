package com.worryswat.asaprest.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
