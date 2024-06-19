package com.example.UMC_WORKBOOK.service.MemberService;

import com.example.UMC_WORKBOOK.web.dto.MemberRequestDTO;
import com.example.UMC_WORKBOOK.domain.entity.Member;

import java.util.Optional;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    Optional<Member> findById(Long id);
}