package com.dev.infrastructure.group;

import com.dev.common.exception.DuplicateEntityException;
import com.dev.domain.group.Group;
import com.dev.domain.group.GroupWriter;
import com.dev.domain.group.group_member.GroupMember;
import com.dev.domain.group.group_member.GroupMemberWriter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * 24.10.14 : Group<RootEntity>을 통해 GroupMember를 저장할 수 있게 Group Domain에서 정의한 interace 구현
 */
@Component
@RequiredArgsConstructor
public class GroupWriterImpl implements GroupWriter, GroupMemberWriter {

    private final GroupRepository groupRepository;
    private final GroupMemberRepository groupMemberRepository;

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getGroup(Long groupId) {
        return groupRepository.findByGroupId(groupId);
    }

    @Transactional
    @Override
    public GroupMember addGroupMember(GroupMember groupMember) {
        try {
            return groupMemberRepository.save(groupMember);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEntityException("Entity 중복");
        }
    }

    @Transactional
    @Override
    public List<GroupMember> addGroupMembers(List<GroupMember> groupMembers) {
        groupMemberRepository.saveAll(groupMembers);
        return groupMembers;
    }


}
