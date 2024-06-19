package com.example.UMC_WORKBOOK.service.MemberService;

import com.example.UMC_WORKBOOK.domain.entity.Member;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findUser(Long id);

    Page<Review> getReviewList(Long userId, Integer page);
}
