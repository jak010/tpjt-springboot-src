package com.dev.infrastructure.member;

import com.dev.domain.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실제 데이터베이스 사용
class MemberReaderImplTest {

    private final static Long groupId = 6L;

    @Autowired
    MemberReaderImpl sut;


    @Test
    @DisplayName("Member 조회 테스트")
    public void getMember() {
        Member savedMember = sut.getMember(groupId);
        Assertions.assertEquals(savedMember.getMemberId(), groupId);
    }



}