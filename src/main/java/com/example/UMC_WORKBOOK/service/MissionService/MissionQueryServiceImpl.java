package com.example.UMC_WORKBOOK.service.MissionService;

import com.example.UMC_WORKBOOK.domain.entity.Member;
import com.example.UMC_WORKBOOK.repository.MemberMissionRepository;
import com.example.UMC_WORKBOOK.repository.MemberRepository;

import java.util.Optional;

public class MissionQueryServiceImpl implements MissionQueryService {
    public MemberMissionRepository memberMissionRepository;
    public MemberRepository memberRepository;
    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }
}
