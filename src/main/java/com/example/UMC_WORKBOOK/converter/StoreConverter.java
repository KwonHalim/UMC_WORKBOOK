package com.example.UMC_WORKBOOK.converter;

import com.example.UMC_WORKBOOK.domain.entity.Mission;
import com.example.UMC_WORKBOOK.domain.entity.Review;
import com.example.UMC_WORKBOOK.domain.entity.Store;
import com.example.UMC_WORKBOOK.web.dto.StoreRequestDTO;
import com.example.UMC_WORKBOOK.web.dto.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


public class StoreConverter {
    public static StoreResponseDTO.AddStoreResultDTO toAddStoreResultDTO(Store store) {
        return StoreResponseDTO.AddStoreResultDTO.builder()
                .StoreId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.AddStoreDTO request) {
        return Store.builder()
                .name(request.getStoreName())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){

        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return StoreResponseDTO.MissionPreViewDTO.builder()
                .dDay(mission.getDeadline())
                .amount(mission.getAmount())
                .point(mission.getReward())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }
    public static StoreResponseDTO.MissonPreViewListDTO missonPreViewListDTO(Page<Mission> missionList){
        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(StoreConverter::missionPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissonPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }


}