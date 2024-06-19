package com.example.UMC_WORKBOOK.web.controller;

import com.example.UMC_WORKBOOK.apiPayload.ApiResponse;
import com.example.UMC_WORKBOOK.converter.MemberConverter;
import com.example.UMC_WORKBOOK.domain.entity.Member;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.service.MemberService.MemberCommandService;
import com.example.UMC_WORKBOOK.service.MemberService.MemberQueryService;
import com.example.UMC_WORKBOOK.web.dto.MemberMissionRequestDTO;
import com.example.UMC_WORKBOOK.web.dto.MemberRequestDTO;
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
@RequestMapping("/users")
@Validated
public class MemberRestController {
    private final MemberCommandService MemberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinReslutDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member Member = MemberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO((Member)));
    }

    @GetMapping("/reviews/{MemberId}")
    @Operation(summary = "특정 유저의 리뷰 목록 조회 API",description = "특정 유저의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "MemberId", description = "유저의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번에 1페이지 입니다")
    })
    public ApiResponse<MemberResponseDTO.GetMyReviewListDTO> getReviewList(
             @PathVariable(name = "MemberId") Long MemberId
            , @RequestParam(name = "page") Integer page){
        Page<Review> review = MemberQueryService.getReviewList(MemberId,page-1);
        return ApiResponse.onSuccess(MemberConverter.getMyReviewListDTO(review));
    }
}
