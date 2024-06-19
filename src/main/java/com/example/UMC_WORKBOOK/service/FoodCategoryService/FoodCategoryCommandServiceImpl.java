package com.example.UMC_WORKBOOK.service.FoodCategoryService;

import com.example.UMC_WORKBOOK.repository.FoodCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodCategoryCommandServiceImpl implements FoodCategoryCommandService {

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean existsById(Long id) {

        return foodCategoryRepository.existsById(id);
    }


}
