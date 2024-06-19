package com.example.UMC_WORKBOOK.web.dto;

import com.example.UMC_WORKBOOK.domain.ReviewImg;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinReslutDTO{
        Long memberId;
        LocalDateTime createdAt;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetMyReviewListDTO{
        List<GetMyReviewDTO> myReviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetMyReviewDTO{
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
        List<ReviewImg> reviewImg;
    }
}
