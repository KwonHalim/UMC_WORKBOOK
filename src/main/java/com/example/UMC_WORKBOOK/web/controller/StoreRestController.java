package com.example.UMC_WORKBOOK.web.controller;

import com.example.UMC_WORKBOOK.apiPayload.ApiResponse;
import com.example.UMC_WORKBOOK.converter.StoreConverter;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.domain.entity.Store;
import com.example.UMC_WORKBOOK.service.StoreService.StoreCommandService;
import com.example.UMC_WORKBOOK.service.StoreService.StoreQueryService;
import com.example.UMC_WORKBOOK.web.dto.StoreDTO;
import com.example.UMC_WORKBOOK.web.dto.StoreRequestDTO;
import com.example.UMC_WORKBOOK.web.dto.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    private final StoreQueryService storeQueryService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReveiwDTO request,
                                                                            @PathVariable(name = "storeId") Long storeId,
                                                                            @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }

    @PostMapping("/create")
    public Store createStore(@RequestBody @Valid StoreDTO storeDTO) {
        return storeQueryService.createStore(storeDTO);
    }

}