package com.dev.infrastructure.member;

import com.dev.domain.group.Group;
import com.dev.domain.group.GroupReader;
import com.dev.domain.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실제 데이터베이스 사용
class MemberWriterImplTest {

    private static final Long testGroupId = 1L;

    @Autowired
    MemberWriterImpl sut;

    @Autowired
    GroupReader groupReader;


    @Test
    @DisplayName("Member Entity 저장 테스트")
    public void memberSaveByJPA() {

        Member newMember = Member.builder()
                .nickName("test")
                .build();

        var savedMember = sut.saveMember(newMember);

        Assertions.assertEquals(
                savedMember.getNickName(),
                "test"
        );
    }

//    @Test
//    @DisplayName("Member 생성 시 그룹 정보와 함께 저장하기")
//    public void memberSavedWithGroup() {
//
//        Group group = groupReader.getGroup(testGroupId);
//
//        Member newMember = Member.builder()
//                .nickName("test2")
//                .group(group)
//                .build();
//
//        var savedMember = sut.saveMember(newMember);
//
//        Assertions.assertEquals(
//                savedMember.get().getGroupId()
//                , testGroupId
//        );
//
//    }

}