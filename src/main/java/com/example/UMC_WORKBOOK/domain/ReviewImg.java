package com.example.UMC_WORKBOOK.domain;

import com.example.UMC_WORKBOOK.domain.common.BaseEntity;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewImg extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewImgId;

    private String imgURL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;
}
