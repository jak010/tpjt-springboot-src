package com.dev.infrastructure.group;

import com.dev.domain.group.Group;
import com.dev.domain.group.GroupWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실제 데이터베이스 사용
class GroupWriterTest {

    @Autowired
    private GroupWriter sut;

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

}