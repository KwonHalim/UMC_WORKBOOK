package com.example.UMC_WORKBOOK.converter;

import com.example.UMC_WORKBOOK.domain.entity.MemberMission;
import com.example.UMC_WORKBOOK.web.dto.MemberMissionPatchRequestDTO;
import com.example.UMC_WORKBOOK.web.dto.MemberMissionPatchResponseDTO;
import com.example.UMC_WORKBOOK.web.dto.MissionResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static MemberMissionPatchResponseDTO.PatchMemberMissionResultDTO toPatchMemberMissionDTO(MemberMission MemberMission){
        return MemberMissionPatchResponseDTO.PatchMemberMissionResultDTO.builder()
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionPatchRequestDTO request){
        return MemberMission.builder()
                .build();
    }

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(MemberMission MemberMission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .dDay(MemberMission.getMission().getDeadline())
                .amount(MemberMission.getMission().getAmount())
                .point(MemberMission.getMission().getReward())
                .createdAt(MemberMission.getMission().getCreatedAt().toLocalDate())
                .build();
    }
    public static MissionResponseDTO.MissonPreViewListDTO missonPreViewListDTO(Page<MemberMission> missionList){
        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MemberMissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissonPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalElements(missionList.getTotalElements())
                .totalPage(missionList.getTotalPages())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

}
