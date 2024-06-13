package com.example.UMC_6th_workbook.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
public class MemberAgree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private com.example.UMC_6th_workbook.domain.entity.Member member;
    @ManyToOne
    @JoinColumn(name = "terms_id")
    private com.example.UMC_6th_workbook.domain.entity.Terms terms;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
