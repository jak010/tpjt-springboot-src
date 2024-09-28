package com.example.member_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name = "Member")
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;


    @Column(length = 200, name = "nick_name")
    private String nickName;


    @Column(name = "createdAt")
    private LocalDateTime createdAt;


    public MemberEntity(String NickName, LocalDateTime createdAt) {
        this.nickName = NickName;
        this.createdAt = createdAt;
    }

}
