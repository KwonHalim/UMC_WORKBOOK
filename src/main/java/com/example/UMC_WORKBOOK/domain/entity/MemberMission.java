package com.example.UMC_6th_workbook.domain.entity;

import com.example.UMC_6th_workbook.domain.Enum.MemberStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
public class MemberMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="member_id")
    private com.example.UMC_6th_workbook.domain.entity.Member member;
    @ManyToOne
    @JoinColumn(name="misison_id")
    private com.example.UMC_6th_workbook.domain.entity.Mission mission;


    @Enumerated(EnumType.STRING)
    private MemberStatus status;


    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}