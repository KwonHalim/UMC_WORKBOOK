package com.example.UMC_WORKBOOK.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    private int reward;
    private LocalDateTime deadline;
    private String mission_spec;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    @OneToMany(mappedBy = "mission")
    private List<MemberMission> memberMissions = new ArrayList<>();


}
