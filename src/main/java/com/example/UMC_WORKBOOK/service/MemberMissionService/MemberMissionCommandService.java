package com.example.UMC_WORKBOOK.service.MemberMissionService;

import com.example.UMC_WORKBOOK.domain.entity.MemberMission;
import com.example.UMC_WORKBOOK.web.dto.MemberMissionPatchRequestDTO;
import org.springframework.data.domain.Page;

public interface MemberMissionCommandService {
    MemberMission patchMemberMissionToDoing(Long missionId, MemberMissionPatchRequestDTO.PatchMemberMissionDTO request);

    MemberMission patchMemberMissionToDone(Long missionId, MemberMissionPatchRequestDTO.PatchMemberMissionDTO request);
    public Page<MemberMission> getMissionList(Long UserId, Integer page);

}
