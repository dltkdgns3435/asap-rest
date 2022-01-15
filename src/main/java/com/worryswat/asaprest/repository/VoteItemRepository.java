package com.worryswat.asaprest.repository;

import com.worryswat.asaprest.entity.VoteItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteItemRepository extends JpaRepository<VoteItem, Long>, JpaSpecificationExecutor<VoteItem> {
}
