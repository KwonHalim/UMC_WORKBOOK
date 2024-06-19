package com.example.UMC_WORKBOOK.web.controller;

import com.example.UMC_WORKBOOK.apiPayload.ApiResponse;
import com.example.UMC_WORKBOOK.converter.MemberMissionConverter;
import com.example.UMC_WORKBOOK.domain.entity.MemberMission;
import com.example.UMC_WORKBOOK.service.MemberMissionService.MemberMissionCommandService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PatchMapping("/doing-missions/{missionId}")
    public ApiResponse<String> patchMemberMissionToDoing(
            @PathVariable("missionId") @Valid Long missionId,
            @RequestBody @Valid MemberMissionPatchRequestDTO.PatchMemberMissionDTO request){

        MemberMission MemberMission = memberMissionCommandService.patchMemberMissionToDoing(missionId, request);
        return ApiResponse.onSuccess("mission 진행중으로 이동 완료");
    }

    @GetMapping("/doing-missions/{MemberId}")
    @Operation(summary = "특정 유저가 진행 중인 미션 목록 조회 API",description = "특정 유저가 진행 중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    public ApiResponse<MissionResponseDTO.MissonPreViewListDTO> getMissionList(
            @PathVariable(name = "MemberId") Long MemberId
            , @RequestParam(name = "page") Integer page){
        Page<MemberMission> mission= MemberMissionCommandService.getMissionList(MemberId, page-1);
        return ApiResponse.onSuccess(MemberMissionConverter.missonPreViewListDTO(mission));
    }
}
