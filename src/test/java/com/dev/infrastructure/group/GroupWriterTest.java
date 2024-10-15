package com.dev.infrastructure.group;

import com.dev.common.exception.DuplicateEntityException;
import com.dev.domain.group.Group;
import com.dev.domain.group.GroupReader;
import com.dev.domain.group.GroupWriter;
import com.dev.domain.group.group_member.GroupMember;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.lang.reflect.Array;
import java.nio.file.attribute.GroupPrincipal;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실제 데이터베이스 사용
class GroupWriterTest {

    private final int testSaveSize = 3;

    @Autowired
    private GroupWriterImpl sut;

    @Autowired
    private GroupReader groupReader;

    @Test
    @DisplayName("Group Entity 저장하기")
    public void groupSaveByGroupWriter() {

        // Arrange
        Group newGroup = Group.builder()
                .groupName("test")
                .build();

        // Act
        Group savedGroup = sut.save(newGroup);

        // Assert
        Assertions.assertEquals(savedGroup.getGroupName(), "test");
    }

    @Test
    @DisplayName("GroupMembers List  저장하기")
    public void groupMembersSaveByGroupWriter() {
        // Arrange

        Group group = groupReader.getGroup(1L);
        List<GroupMember> groupMemberList = new ArrayList<>();
        for (long i = 0; i < testSaveSize; i++) {
            GroupMember groupMember = GroupMember.builder()
                    .group(group)
                    .memberId(i)
                    .build();
            groupMemberList.add(groupMember);
        }

        // Act
        sut.addGroupMembers(groupMemberList);

        // Assert
        Assertions.assertEquals(group.getMemberTotal(), testSaveSize);

    }

    @Test
    @DisplayName("하나의 Group에 동일한 GroupMember가 존재할 수 없음")
    public void DuplicateGroupMemberSave() {

        // Arrange

        Group group = groupReader.getGroup(1L);

        GroupMember groupMember1 = GroupMember.builder()
                .group(group)
                .memberId(1L)
                .build();
        GroupMember groupMember2 = GroupMember.builder()
                .group(group)
                .memberId(1L)
                .build();

        // Act
        sut.addGroupMember(groupMember1);


        // Assert
        Assertions.assertThrows(DuplicateEntityException.class, () -> {
            sut.addGroupMember(groupMember2);
        });

    }


//    @Test
//    @DisplayName("1만건의 GroupMember를 save로 처리 시 걸리는 시간 측정하기")
//    public void groupMembersSaveByGroupWriterWithJpaSave() {
//        // Arrange
//        Group group = groupReader.getGroup(1L);
//
//        // Act
//        for (long i = 0; i < 10_000; i++) {
//            GroupMember groupMember = GroupMember.builder()
//                    .group(group)
//                    .memberId(i)
//                    .build();
//            sut.addGroupMember(groupMember);
//        }
//
//
//        // Assert
//        Assertions.assertEquals(group.getMemberTotal(), 10_000);
//    }

//    @Test
//    @DisplayName("1만건의 GroupMember를 saveAll로 처리 시 걸리는 시간 측정하기")
//    public void groupMembersSaveByGroupWriterWithJpaSaveAll() {
//        // Arrange
//        Group group = groupReader.getGroup(1L);
//        List<GroupMember> groupMemberList = new ArrayList<>();
//        for (long i = 0; i < 10_000; i++) {
//            GroupMember groupMember = GroupMember.builder()
//                    .group(group)
//                    .memberId(i)
//                    .build();
//            groupMemberList.add(groupMember);
//        }
//
//
//        // Act
//        sut.addGroupMembers(groupMemberList);
//
//        // Assert
//        Assertions.assertEquals(group.getMemberTotal(), 10_000);
//
//    }

}