package com.example.UMC_WORKBOOK.converter;

import com.example.UMC_WORKBOOK.domain.entity.FoodCategory;
import com.example.UMC_WORKBOOK.domain.entity.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
