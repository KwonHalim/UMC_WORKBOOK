package com.example.UMC_WORKBOOK.service.MemberMissionService;

import com.example.UMC_WORKBOOK.domain.entity.MemberMission;
import org.springframework.data.domain.Page;

public interface MemberMissionCommandService {
    MemberMission patchMemberMissionToDoing(Long missionId, MemberMissionPatchRequestDTO.PatchUserMissionDTO request);
    public Page<MemberMission> getMissionList(Long UserId, Integer page);

}
