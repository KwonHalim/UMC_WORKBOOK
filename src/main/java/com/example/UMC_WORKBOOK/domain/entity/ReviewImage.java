package com.example.UMC_WORKBOOK.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class ReviewImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "review_id")
    private com.example.UMC_WORKBOOK.domain.entity.Review review;
    private String image_url;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}