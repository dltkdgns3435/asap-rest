package com.worryswat.asaprest.domain.question.service;

import com.worryswat.asaprest.domain.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    //질문 생성
    //옵션 질문, 질문+투표, 투표, 제한시간 여부

    //큰 카테고리
    //질문 조회(dto 페이징) -> 에디터1: 답변 있는것 조회
    //질문 조회(dto 페이징) -> 에디터1: 답변 있는것 + 제한시간 있는것 조회
    //질문 조회(dto 페이징) -> 에디터2: 답변 없는것 조회(투표 기능만 있는것)

    //특정 정보
    //질문 조회(숫자) -> 모든 질문 갯수

    //세부 검색
    //질문 조회(dto 페이징) -> 콘텐츠 내용으로 검색
    //질문 조회(dto 페이징) -> 마감시간이 얼마 안남은것 중 가장


    //질문 수정
    //질문 삭제
}
