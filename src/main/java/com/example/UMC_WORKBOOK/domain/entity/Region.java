package com.example.UMC_WORKBOOK.domain.entity;

import com.example.UMC_WORKBOOK.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long regionId;

    @Column(nullable = false, length = 45)
    private String region;
}
