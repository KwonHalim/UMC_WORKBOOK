package com.example.UMC_WORKBOOK.repository;

import com.example.UMC_WORKBOOK.domain.Enum.MissionType;
import com.example.UMC_WORKBOOK.domain.entity.Member;
import com.example.UMC_WORKBOOK.domain.entity.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Object> {
    Optional<MemberMission> findMissionByMission_MissionIdAndMember_MemberId(Long missionId, Long userId);

    Page<MemberMission> findAllByMemberAndMissionType(Member member, MissionType missionType , PageRequest pageRequest);
}