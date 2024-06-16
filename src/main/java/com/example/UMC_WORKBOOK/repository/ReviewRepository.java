package com.example.UMC_WORKBOOK.repository;

import com.example.UMC_WORKBOOK.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}