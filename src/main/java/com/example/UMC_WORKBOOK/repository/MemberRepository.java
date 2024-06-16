package com.example.UMC_WORKBOOK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.UMC_WORKBOOK.domain.entity.Member;
public interface MemberRepository extends JpaRepository<Member, Long> {
}