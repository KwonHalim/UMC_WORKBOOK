package com.example.UMC_WORKBOOK.apiPayload.exception.handler;

import com.example.UMC_WORKBOOK.apiPayload.code.BaseErrorCode;
import com.example.UMC_WORKBOOK.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode errorCode){ super(errorCode);}
}

