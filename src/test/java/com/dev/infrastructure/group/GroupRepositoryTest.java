package com.dev.infrastructure.group;

import com.dev.domain.group.Group;
import com.dev.domain.group.GroupWriter;
import com.dev.domain.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실제 데이터베이스 사용
class GroupRepositoryTest {

    @Autowired
    private GroupWriter groupWriter;

    @Test
    @DisplayName("Group Entity 저장하기")
    public void groupSaveByGroupWriter() {

        Group newGroup = Group.builder()
                .groupName("test")
                .build();
        System.out.println(newGroup);
        Group savedGroup = groupWriter.save(newGroup);

        Assertions.assertEquals(savedGroup.getGroupName(), "test");
    }

    @Test
    @DisplayName("GroupId 로 조회")
    public void getGroupByGroupId() {

        Group group = groupWriter.getGroup(6L);

        for (Member member : group.getMemberList()) {
            System.out.println(member);
        }

        Assertions.assertEquals(group.getMemberList().size(), 3);
    }

}