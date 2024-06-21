package com.example.UMC_WORKBOOK.service.StoreService;

import com.example.UMC_WORKBOOK.domain.entity.Mission;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.domain.entity.Store;
import com.example.UMC_WORKBOOK.repository.MemberRepository;
import com.example.UMC_WORKBOOK.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface StoreCommandService {

    Store addStore(StoreRequestDTO.AddStoreDTO request);

    Optional<Store> findById(Long id);
    Boolean existsById(Long id);
}