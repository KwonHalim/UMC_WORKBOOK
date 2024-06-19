package com.example.UMC_WORKBOOK.service.MissionService;

import com.example.UMC_WORKBOOK.domain.entity.Member;

import java.util.Optional;

public interface MissionQueryService {
    public Optional<Member> findMember(Long id);
}
