package com.example.UMC_WORKBOOK.service.StoreService;

import com.example.UMC_WORKBOOK.domain.entity.Region;
import com.example.UMC_WORKBOOK.domain.entity.Store;
import com.example.UMC_WORKBOOK.web.dto.StoreDTO;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    Store createStore(StoreDTO storeDTO);
}
