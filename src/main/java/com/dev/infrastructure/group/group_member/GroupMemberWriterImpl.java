package com.dev.infrastructure.group.group_member;

import com.dev.domain.group.group_member.GroupMember;
import com.dev.domain.group.group_member.GroupMemberWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GroupMemberWriterImpl implements GroupMemberWriter {


    private final GroupMemberRepository groupMemberRepository;

    @Override
    public GroupMember addGroupMember(GroupMember groupMember) {
        return groupMemberRepository.save(groupMember);
    }
}
