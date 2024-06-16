package com.example.UMC_WORKBOOK.service.StoreService;

import com.example.UMC_WORKBOOK.domain.entity.Mission;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.repository.MemberRepository;
import com.example.UMC_WORKBOOK.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface StoreCommandService {

    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReveiwDTO request);

    void createMission(String missionDescription, long storeId);
}