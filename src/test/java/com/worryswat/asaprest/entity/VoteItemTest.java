package com.worryswat.asaprest.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class VoteItemTest {

    @Test
    @DisplayName("투표 득표")
    void voted() {
        //given
        VoteItem voteItem = VoteItem.builder()
                .title("찬성")
                .build();
        //when
        voteItem.voted();

        //then
        assertThat(voteItem.getVoteCount()).isEqualTo(1);
    }
}