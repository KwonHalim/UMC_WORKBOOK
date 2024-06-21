package com.example.UMC_WORKBOOK.converter;

import com.example.UMC_WORKBOOK.domain.Enum.Gender;
import com.example.UMC_WORKBOOK.domain.entity.Member;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.web.dto.MemberRequestDTO;
import com.example.UMC_WORKBOOK.web.dto.MemberResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {
    public static MemberResponseDTO.JoinReslutDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinReslutDTO.builder()
                .memberId(member.getMemberId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch(request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();

    }

    public static MemberResponseDTO.GetMyReviewDTO getMyReviewDTO(Review review){
        return MemberResponseDTO.GetMyReviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .reviewImg(review.getReviewImageList())
                .build();
    }
    public static MemberResponseDTO.GetMyReviewListDTO getMyReviewListDTO(Page<Review> reviewList){
        List<MemberResponseDTO.GetMyReviewDTO> myReviewDTOList = reviewList.stream()
                .map(MemberConverter::getMyReviewDTO).collect(Collectors.toList());
        return MemberResponseDTO.GetMyReviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(myReviewDTOList.size())
                .myReviewList(myReviewDTOList)
                .build();
    }
}
