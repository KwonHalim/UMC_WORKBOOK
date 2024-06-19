package com.example.UMC_WORKBOOK.service.StoreService;

import com.example.UMC_WORKBOOK.apiPayload.code.status.ErrorStatus;
import com.example.UMC_WORKBOOK.apiPayload.exception.handler.RegionHandler;
import com.example.UMC_WORKBOOK.converter.StoreConverter;
import com.example.UMC_WORKBOOK.domain.entity.Mission;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.domain.entity.Store;
import com.example.UMC_WORKBOOK.repository.*;
import com.example.UMC_WORKBOOK.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store addStore(StoreRequestDTO.AddStoreRequestDTO request) {

        Store newStore = StoreConverter.toStore(request);

        newStore.setRegion(regionRepository.findById(request.getId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND)));

        return storeRepository.save(newStore);
    }

    @Override
    public Optional<Store> findById(Long id){
        return storeRepository.findById(id);
    }

    @Override
    public Boolean existsById(Long id){
        return storeRepository.existsById(id);
    }

}