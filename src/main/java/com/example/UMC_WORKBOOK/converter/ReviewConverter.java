package com.example.UMC_WORKBOOK.converter;

import com.example.UMC_WORKBOOK.domain.ReviewImg;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.service.MemberService.MemberCommandServiceImpl;
import com.example.UMC_WORKBOOK.service.StoreService.StoreCommandService;
import com.example.UMC_WORKBOOK.web.dto.ReviewRequestDTO;
import com.example.UMC_WORKBOOK.web.dto.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReviewConverter {

    private static MemberCommandServiceImpl memberCommandService;
    private static StoreCommandService storeCommandService;

    public static ReviewResponseDTO.PostReviewResultDTO toPostReviewResultDTO(Review review){
        return ReviewResponseDTO.PostReviewResultDTO.builder()
                .reviewId(review.getReviewId())
                .createdAt(review.getCreatedAt())
                .build();
    }


    public static List<ReviewImg> toReviewImgList(List<ReviewRequestDTO.ReviewImgDTO> reviewImgDTOList){
//        reviewImg.stream().map(img -> ReviewImg.builder()
//                .imgURL(img)
//                .build()).collect(Collectors.toList());

        return reviewImgDTOList.stream()
                .map(imgDTO -> ReviewImg.builder().imgURL(imgDTO.getImgUrl()).build())
                .collect(Collectors.toList());
    }
    public static Review toReview(ReviewRequestDTO.PostReviewDTO request){
        return Review.builder()
                .reviewImageList(toReviewImgList(request.getReviewImg()))
                .reviewBody(request.getReviewBody())
                .score(request.getScore())
                .createdAt(LocalDateTime.now())
                .build();
    }



}