package com.example.UMC_WORKBOOK.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class AddStoreDTO {
        @NotBlank
        String storeName;

        @NotNull
        Long regionId;

    }
}
