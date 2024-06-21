package com.example.UMC_WORKBOOK.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MemberMissionPatchRequestDTO {
    @Getter
    public static class PatchMemberMissionDTO {

        @NotNull
        Long memberId;
    }
}
