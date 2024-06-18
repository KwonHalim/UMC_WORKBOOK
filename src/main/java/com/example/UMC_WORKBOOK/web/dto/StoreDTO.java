package com.example.UMC_WORKBOOK.web.dto;


import com.example.UMC_WORKBOOK.domain.entity.Region;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoreDTO {
    private String name;
    private String address;
    private Float score;
    private Region region;
}
