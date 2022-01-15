package com.worryswat.asaprest.domain.question.query;

import com.worryswat.asaprest.domain.question.entity.Question;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionSpecification {

    //삭제되지 않고, 콘텐츠에 검색어가 포함된 조건
    public Specification<Question> searchByContent(String searchWord) {
        return (root, query, builder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            predicateList.add(this.notDeleted(root, builder));
            predicateList.add(this.likeContent(searchWord, root, builder));

            return builder.and(predicateList.toArray(new  Predicate[0]));
        };
    }


    //삭제되지 않은 조건 쿼리
    private Predicate notDeleted(Root<Question> root, CriteriaBuilder builder) {
        return builder.isNull(root.get("deletedAt"));
    }


    //콘텐츠 포함여부 조건 쿼리
    private Predicate likeContent(String searchWord, Root<Question> root, CriteriaBuilder builder) {
        return builder.like(root.get("content"), "%" + searchWord + "%");
    }
}
