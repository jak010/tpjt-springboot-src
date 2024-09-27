package com.example.member_service.entity;

import com.example.member_service.dto.MemberDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
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
