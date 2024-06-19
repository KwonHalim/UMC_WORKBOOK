package com.example.UMC_WORKBOOK.service.ReviewService;

import com.example.UMC_WORKBOOK.domain.entity.Review;

public interface ReviewCommandService {
    Review postReview(ReviewRequestDTO.PostReviewDTO request);
}
