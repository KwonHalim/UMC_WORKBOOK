package com.example.UMC_WORKBOOK.converter;

import com.example.UMC_WORKBOOK.domain.entity.Mission;
import com.example.UMC_WORKBOOK.web.dto.MissionPatchRequestDTO;
import com.example.UMC_WORKBOOK.web.dto.MissionPatchResponseDTO;

public class MissionConverter {
    public static MissionPatchResponseDTO.PatchMissionResultDTO toPatchMissionDTO(Mission mission){
        return MissionPatchResponseDTO.PatchMissionResultDTO.builder()
                .build();
    }

    public static Mission toMission(MissionPatchRequestDTO request){
        return Mission.builder()
                .build();
    }



}
