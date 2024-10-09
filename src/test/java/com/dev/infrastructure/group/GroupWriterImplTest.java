package com.dev.infrastructure.group;

import com.dev.domain.group.Group;
import com.dev.domain.group.GroupWriter;
import jakarta.validation.GroupSequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실제 데이터베이스 사용
class GroupWriterImplTest {

    @Autowired
    GroupRepository groupRepository;

    @Test
    @DisplayName("Group Entity 저장하기")
    public void groupSaveByGroupWriter() {

        Group newGroup = Group.builder()
                .groupName("test")
                .build();
        System.out.println(newGroup);
        Group savedGroup = groupRepository.save(newGroup);

        Assertions.assertEquals(savedGroup.getGroupName(), "test");

    }

}