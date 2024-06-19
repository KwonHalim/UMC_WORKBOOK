package com.example.UMC_WORKBOOK.domain.entity;


import com.example.UMC_WORKBOOK.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    private int reward;
    private LocalDateTime deadline;
    private String mission_spec;

    private Integer amount;
    @OneToMany(mappedBy = "mission")
    private List<MemberMission> memberMissions = new ArrayList<>();
}
