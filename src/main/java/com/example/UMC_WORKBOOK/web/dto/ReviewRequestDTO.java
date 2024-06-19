package com.example.UMC_WORKBOOK.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

public class ReviewRequestDTO {
    @Getter
    public static class PostReviewDTO {
        @NotNull
        Long restaurantId;

        @NotNull
        Long userId;

        @NotNull
        Float score;

        @NotBlank
        String reviewBody;

        @NotNull
        List<ReviewImgDTO> reviewImg;
    }
    @Getter
    public static class ReviewImgDTO{
        String imgUrl;
    }
}
