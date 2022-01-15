package com.worryswat.asaprest.domain.question.repository;

import com.worryswat.asaprest.domain.question.entity.VoteItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteItemRepository extends JpaRepository<VoteItem, Long>, JpaSpecificationExecutor<VoteItem> {
}
