package com.dev.infrastructure.group;

import com.dev.domain.group.Group;
import com.dev.domain.group.GroupWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GroupWriterImpl implements GroupWriter {

    private final GroupRepository groupRepository;

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getGroup(Long groupId) {
        return groupRepository.findByGroupId(groupId);
    }


}
