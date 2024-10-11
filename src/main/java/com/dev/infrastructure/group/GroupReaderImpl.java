package com.dev.infrastructure.group;

import com.dev.domain.group.Group;
import com.dev.domain.group.GroupReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GroupReaderImpl implements GroupReader {

    private final GroupRepository groupRepository;

    @Override
    public Group getGroup(Long groupId) {
        return groupRepository.findByGroupId(groupId);
    }

}
