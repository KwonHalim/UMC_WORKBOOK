package com.example.UMC_WORKBOOK.service.ReviewService;

import com.example.UMC_WORKBOOK.apiPayload.code.status.ErrorStatus;
import com.example.UMC_WORKBOOK.apiPayload.exception.handler.MemberHandler;
import com.example.UMC_WORKBOOK.apiPayload.exception.handler.RestaurantHandler;
import com.example.UMC_WORKBOOK.converter.ReviewConverter;
import com.example.UMC_WORKBOOK.domain.entity.Member;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.domain.entity.Store;
import com.example.UMC_WORKBOOK.repository.MemberRepository;
import com.example.UMC_WORKBOOK.repository.ReviewRepository;
import com.example.UMC_WORKBOOK.repository.StoreRepository;
import com.example.UMC_WORKBOOK.web.dto.ReviewRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final MemberRepository userRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review postReview(ReviewRequestDTO.PostReviewDTO request) {
        Review newReview = ReviewConverter.toReview(request);

        Member user =  userRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.USER_NOT_FOUND));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(()->new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        newReview.setReview(user, store);

        return reviewRepository.save(newReview);
    }
}
