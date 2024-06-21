package com.example.UMC_WORKBOOK.service.ReviewService;

import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review postReview(ReviewRequestDTO.PostReviewDTO request);
}
