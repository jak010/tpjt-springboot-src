package com.dev.infrastructure.group;

import com.dev.domain.group.GroupReader;
import com.dev.domain.group.group_member.GroupMember;
import com.dev.domain.group.group_member.GroupMemberWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실제 데이터베이스 사용
class GroupReaderImplTest {

    @Autowired
    private GroupReader sut;

    @Autowired
    private GroupMemberWriter groupMemberWriter;

    @Test
    @DisplayName("Group을 통해 GroupMember 읽기")
    void groupRead() {

        // Arrange
        var group = sut.getGroup(1L);
        for (long i = 0; i < 3; i++) {
            var groupMember = GroupMember.builder()
                    .group(group)
                    .memberId(i)
                    .build();
            groupMemberWriter.addGroupMember(groupMember);
        }

        var savedGroup = sut.getGroup(1L);

        // Assert
        Assertions.assertEquals(savedGroup.getGroupMembers().size(), 3);


    }

}