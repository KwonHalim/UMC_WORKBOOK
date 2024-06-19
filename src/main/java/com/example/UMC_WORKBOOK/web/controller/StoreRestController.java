package com.example.UMC_WORKBOOK.web.controller;

import com.example.UMC_WORKBOOK.apiPayload.ApiResponse;
import com.example.UMC_WORKBOOK.converter.ReviewConverter;
import com.example.UMC_WORKBOOK.converter.StoreConverter;
import com.example.UMC_WORKBOOK.domain.entity.Mission;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.domain.entity.Store;
import com.example.UMC_WORKBOOK.service.ReviewService.ReviewCommandService;
import com.example.UMC_WORKBOOK.service.StoreService.StoreCommandService;
import com.example.UMC_WORKBOOK.service.StoreService.StoreQueryService;
import com.example.UMC_WORKBOOK.web.dto.StoreDTO;
import com.example.UMC_WORKBOOK.web.dto.StoreRequestDTO;
import com.example.UMC_WORKBOOK.web.dto.StoreResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/Store")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.AddStoreResultDTO> addStore(@RequestBody @Valid StoreRequestDTO.AddStoreDTO request){
        Store Store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddStoreResultDTO(Store));
    }

    @PostMapping("/reviews")
    public ApiResponse<ReviewResponseDTO.PostReviewResultDTO> postReview(@RequestBody @Valid ReviewRequestDTO.PostReviewDTO request){
        Review review = reviewCommandService.postReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toPostReviewResultDTO(review));
    }

    @GetMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(
             @PathVariable(name = "storeId") Long storeId
            , @RequestParam(name = "page") Integer page){
        Page<Review> review= storeQueryService.getReviewList(storeId, page-1);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(review));
        //return null;
    }

    @GetMapping("/{storeId}/missions")
    public ApiResponse<StoreResponseDTO.MissonPreViewListDTO> getMissionList(
             @PathVariable(name = "storeId") Long storeId
            , @RequestParam(name = "page") Integer page){
        Page<Mission> mission= StoreQueryService.getMissionList(storeId, page-1);
        return ApiResponse.onSuccess(StoreConverter.missonPreViewListDTO(mission));
    }
}