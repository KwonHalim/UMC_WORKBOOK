package com.example.UMC_WORKBOOK.web.controller;

import com.example.UMC_WORKBOOK.apiPayload.ApiResponse;
import com.example.UMC_WORKBOOK.converter.MemberConverter;
import com.example.UMC_WORKBOOK.domain.entity.Member;
import com.example.UMC_WORKBOOK.service.MemberService.MemberCommandService;
import com.example.UMC_WORKBOOK.web.dto.MemberRequestDTO;
import com.example.UMC_WORKBOOK.web.dto.MemberResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/challenge")
    public void newMission() {

    }

}