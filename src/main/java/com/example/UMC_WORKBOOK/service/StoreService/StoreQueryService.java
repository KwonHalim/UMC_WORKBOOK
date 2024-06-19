package com.example.UMC_WORKBOOK.service.StoreService;

import com.example.UMC_WORKBOOK.domain.entity.Mission;
import com.example.UMC_WORKBOOK.domain.entity.Region;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.domain.entity.Store;
import com.example.UMC_WORKBOOK.web.dto.StoreDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    Page<Review> getReviewList(Long StoreId, Integer page);
    Page<Mission> getMissionList(Long StoreId, Integer page);
}
