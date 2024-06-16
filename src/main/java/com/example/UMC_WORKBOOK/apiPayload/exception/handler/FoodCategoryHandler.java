package com.example.UMC_WORKBOOK.apiPayload.exception.handler;

import com.example.UMC_WORKBOOK.apiPayload.code.BaseErrorCode;
import com.example.UMC_WORKBOOK.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}