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
import com.example.UMC_WORKBOOK.web.dto.*;
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
    @Operation(summary = "리뷰 목록 조회 API",description = "")
    public ApiResponse<ReviewResponseDTO.PostReviewResultDTO> postReview(@RequestBody @Valid ReviewRequestDTO.PostReviewDTO request){
        Review review = reviewCommandService.postReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toPostReviewResultDTO(review));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(
             @PathVariable(name = "storeId") Long storeId
            , @RequestParam(name = "page") Integer page){
        Page<Review> review= storeQueryService.getReviewList(storeId, page-1);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(review));
        //return null;
    }

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호")
    })
    public ApiResponse<StoreResponseDTO.MissonPreViewListDTO> getMissionList(
             @PathVariable(name = "storeId") Long storeId
            , @RequestParam(name = "page") Integer page){
        Page<Mission> mission= storeQueryService.getMissionList(storeId, page-1);
        return ApiResponse.onSuccess(StoreConverter.missonPreViewListDTO(mission));
    }
}