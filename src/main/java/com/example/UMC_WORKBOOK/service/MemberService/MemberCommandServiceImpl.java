package com.example.UMC_WORKBOOK.service.MemberService;

import com.example.UMC_WORKBOOK.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.UMC_WORKBOOK.converter.MemberConverter;
import com.example.UMC_WORKBOOK.converter.MemberPreferConverter;
import com.example.UMC_WORKBOOK.domain.entity.Member;
import com.example.UMC_WORKBOOK.apiPayload.code.status.ErrorStatus;
import com.example.UMC_WORKBOOK.domain.entity.FoodCategory;
import com.example.UMC_WORKBOOK.domain.entity.MemberPrefer;
import com.example.UMC_WORKBOOK.repository.FoodCategoryRepository;
import com.example.UMC_WORKBOOK.repository.MemberRepository;
import com.example.UMC_WORKBOOK.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request){

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                return foodCategoryRepository.findById(category)
                        .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(MemberPrefer -> {MemberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    public Optional<Member> findById(Long id){
        return memberRepository.findById(id);
    }
}
