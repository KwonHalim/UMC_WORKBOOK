package com.example.UMC_6th_workbook.domain.entity;

import com.example.UMC_6th_workbook.domain.Enum.Gender;
import com.example.UMC_6th_workbook.domain.Enum.MemberStatus;
import com.example.UMC_6th_workbook.domain.Enum.SocialType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    private String address;
    private String spec_address;
    @Enumerated(EnumType.STRING)
    private MemberStatus status;
    private LocalDateTime inactive_date;
    @Enumerated(EnumType.STRING)
    private SocialType social_type;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String email;
    private int point;

    @OneToMany(mappedBy = "member")
    private List<MemberMission> MemberMissions;

    @OneToMany(mappedBy = "member")
    private List<MemberAgree> memberAgrees;

    @OneToMany(mappedBy = "member")
    private List<MemberPrefer> memberPrefers;

    @OneToMany(mappedBy = "member")
    private List<Review> reviews;


}