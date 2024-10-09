package com.dev.domain.member;

import com.dev.domain.AbstractEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor
public class Member extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(length = 200, name = "nick_name")
    private String nickName;


    @Column(length = 200, name = "nick_name", nullable = true)
    private Integer groupId;

    @Column(length = 10, name = "grade")
    @Enumerated(EnumType.STRING)
    private Grade grade;


    @Builder
    public Member(String nickName) {
        this.nickName = validationCheckNickName(nickName);
        this.grade = Grade.NORMAL;
    }


    @Getter
    @RequiredArgsConstructor
    public enum Grade {
        NORMAL("일반"), ADMIN("관리자");

        private final String description;
    }


    private String validationCheckNickName(String nickName) {
        if (nickName.length() > 12) {
            throw new RuntimeException("NickName은 12글자를 넘을 수 없다.");
        }
        return nickName;
    }


    public void changeGrade(Grade grade) {
        this.grade = grade;
    }

}
