package com.example.UMC_6th_workbook.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private com.example.UMC_6th_workbook.domain.entity.Member member;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private com.example.UMC_6th_workbook.domain.entity.Store store;
    private String body;
    private float score;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "review")
    private List<com.example.UMC_6th_workbook.domain.entity.ReviewImage> reviewImages;
}