package com.example.UMC_WORKBOOK.service.StoreService;

import com.example.UMC_WORKBOOK.domain.entity.Mission;
import com.example.UMC_WORKBOOK.domain.entity.Region;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.domain.entity.Store;
import com.example.UMC_WORKBOOK.repository.MissionRepository;
import com.example.UMC_WORKBOOK.repository.RegionRepository;
import com.example.UMC_WORKBOOK.repository.ReviewRepository;
import com.example.UMC_WORKBOOK.repository.StoreRepository;
import com.example.UMC_WORKBOOK.web.dto.StoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository StoreRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id){
        return StoreRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page){
        Store Store = StoreRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(Store, PageRequest.of(page,10));
        return StorePage;
    }

    @Override
    public Page<Mission> getMissionList(Long StoreId, Integer page){
        Store Store = StoreRepository.findById(StoreId).get();
        Page<Mission> StorePage = missionRepository.findAllByStore(Store, PageRequest.of(page, 10));
        return StorePage;
    }

}
