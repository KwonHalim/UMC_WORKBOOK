package com.example.UMC_WORKBOOK.service.MemberMissionService;

import com.example.UMC_WORKBOOK.apiPayload.code.status.ErrorStatus;
import com.example.UMC_WORKBOOK.apiPayload.exception.handler.MissionHandler;
import com.example.UMC_WORKBOOK.domain.Enum.MissionType;
import com.example.UMC_WORKBOOK.domain.entity.Member;
import com.example.UMC_WORKBOOK.domain.entity.MemberMission;
import com.example.UMC_WORKBOOK.repository.MemberMissionRepository;
import com.example.UMC_WORKBOOK.repository.MemberRepository;
import com.example.UMC_WORKBOOK.web.dto.MemberMissionPatchRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j //logger
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;


    @Override
    public MemberMission patchMemberMissionToDoing(Long missionId, MemberMissionPatchRequestDTO.PatchMemberMissionDTO request) {
        MemberMission memberMission = memberMissionRepository.findMissionByMission_MissionIdAndMember_MemberId(missionId, request.getMemberId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        if (memberMission.getMissionType() == MissionType.doing)
            throw new MissionHandler(ErrorStatus.MISSION_ALREADY_DOING);
        else
            memberMission.setMissionType(MissionType.doing);

        return memberMissionRepository.save(memberMission);
    }

    @Override
    public MemberMission patchMemberMissionToDone(Long missionId, MemberMissionPatchRequestDTO.PatchMemberMissionDTO request) {
        MemberMission memberMission = memberMissionRepository.findMissionByMission_MissionIdAndMember_MemberId(missionId, request.getMemberId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        if (memberMission.getMissionType() == MissionType.done)
            throw new MissionHandler(ErrorStatus.MISSION_ALREADY_DOING);
        else
            memberMission.setMissionType(MissionType.done);

        return memberMissionRepository.save(memberMission);
    }

    @Override
    public Page<MemberMission> getMissionList(Long MemberId, Integer page) {
        log.trace("trace log={}", page);
        log.info("info log={}", page);
        Member member = memberRepository.findById(MemberId).get();
        Page<MemberMission> MissionPage = memberMissionRepository.findAllByMemberAndMissionType(member, MissionType.doing, PageRequest.of(page, 10));
        return MissionPage;
    }
}
