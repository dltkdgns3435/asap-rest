package com.worryswat.asaprest.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class VoteItemTest {

    @Test
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