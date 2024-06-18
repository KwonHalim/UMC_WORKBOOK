package com.example.UMC_WORKBOOK.service.StoreService;

import com.example.UMC_WORKBOOK.domain.entity.Region;
import com.example.UMC_WORKBOOK.domain.entity.Store;
import com.example.UMC_WORKBOOK.repository.RegionRepository;
import com.example.UMC_WORKBOOK.repository.StoreRepository;
import com.example.UMC_WORKBOOK.web.dto.StoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return Optional.empty();
    }



    public Store createStore(StoreDTO storeDtO) {
        Store store = new Store();
        // 3. Store 엔티티 저장
        return storeRepository.save(store);
    }
}