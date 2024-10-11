package com.dev.infrastructure.group;

import com.dev.domain.group.group_member.GroupMember;
import com.dev.infrastructure.group.group_member.GroupMemberWriterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실제 데이터베이스 사용
class GroupMemberWriterImplTest {

    @Autowired
    private GroupMemberWriterImpl sut;

    @Autowired
    private GroupReaderImpl groupReader;

    @Test
    @DisplayName("Group Member 추가하기")
    public void testAddGroupMember() {

        var group = groupReader.getGroup(1L);

        GroupMember newGroupMember = GroupMember.builder()
                .group(group)
                .memberId(1L)
                .build();

        GroupMember savedGroupMember = sut.addGroupMember(newGroupMember);

        Assertions.assertEquals(savedGroupMember.getGroup().getGroupId(), 1L);

    }

}