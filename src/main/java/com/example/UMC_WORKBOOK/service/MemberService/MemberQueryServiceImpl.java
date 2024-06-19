package com.example.UMC_WORKBOOK.service.MemberService;

import com.example.UMC_WORKBOOK.domain.entity.Member;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.repository.MemberRepository;
import com.example.UMC_WORKBOOK.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public Optional<Member> findUser(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long userId, Integer page) {

        Member member = memberRepository.findById(userId).get();

        Page<Review> MemberPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return MemberPage;
    }
}
