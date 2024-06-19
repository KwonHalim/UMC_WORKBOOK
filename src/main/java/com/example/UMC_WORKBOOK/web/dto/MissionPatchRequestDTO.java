package com.example.UMC_WORKBOOK.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionPatchRequestDTO {
    @Getter
    public static class PatchMissionDTO {

        @NotNull
        Long userId;
    }
}
