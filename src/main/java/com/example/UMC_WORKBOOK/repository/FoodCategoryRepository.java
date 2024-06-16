package com.example.UMC_WORKBOOK.repository;

import com.example.UMC_WORKBOOK.domain.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}