package com.example.UMC_WORKBOOK.service.TempService;

import com.example.UMC_WORKBOOK.apiPayload.code.status.ErrorStatus;
import com.example.UMC_WORKBOOK.apiPayload.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {
    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
