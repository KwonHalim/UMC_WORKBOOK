package com.example.UMC_WORKBOOK.domain.entity;

import com.example.UMC_WORKBOOK.domain.Enum.MemberStatus;
import com.example.UMC_WORKBOOK.domain.Enum.MissionType;
import com.example.UMC_WORKBOOK.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name="misison_id")
    private Mission mission;


    @Enumerated(EnumType.STRING)
    private MissionType missionType;

    public void setMissionType(MissionType t){
        this.missionType = t;
    }

}