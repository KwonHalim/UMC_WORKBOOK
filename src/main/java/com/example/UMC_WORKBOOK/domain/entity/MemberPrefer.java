package com.example.UMC_WORKBOOK.domain.entity;

import com.example.UMC_WORKBOOK.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MemberPreferid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Member_id")
    private Member Member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodCategory_id")
    private FoodCategory foodCategory;




    public void setMember(Member Member){
        if(this.Member != null)
            Member.getMemberPreferList().remove(this);
        this.Member = Member;
        Member.getMemberPreferList().add(this);
    }

    public void setFoodCategory(FoodCategory foodCategory){
        this.foodCategory = foodCategory;
    }
}
