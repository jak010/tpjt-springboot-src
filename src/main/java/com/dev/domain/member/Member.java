package com.dev.domain.member;

import com.dev.domain.AbstractEntity;
import com.dev.domain.group.Group;
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

    @Column(name = "nick_name")
    private String nickName;


    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
    private Grade grade;


    @Builder
    public Member(String nickName, Group group) {
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
