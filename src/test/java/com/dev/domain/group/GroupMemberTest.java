package com.dev.domain.group;

import com.dev.domain.group.group_member.GroupMember;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class GroupMemberTest {


    @Test
    @DisplayName("Group Member 추가")
    public void addGroupMember() {

        Group testGroup = Group.builder()
                .groupName("test1")
                .build();

        GroupMember groupMember = GroupMember.builder()
                .group(testGroup)
                .memberId(1L)
                .build();

        Assertions.assertEquals(groupMember.getGroup().getGroupName(), "test1");
    }


}