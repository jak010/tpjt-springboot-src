package com.dev.domain.group;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GroupTest {

    @Test
    @DisplayName("Group Entity 테스트")
    public void initGroupEntity() {

        Group group = Group.builder()
                .groupName("test")
                .build();

        Assertions.assertEquals(group.getGroupName(), "test");
    }

}