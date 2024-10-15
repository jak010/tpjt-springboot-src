package com.dev.domain.group.group_member;

import java.util.List;

public interface GroupMemberWriter {

    GroupMember addGroupMember(GroupMember groupMember);

    List<GroupMember> addGroupMembers(List<GroupMember> groupMembers);
}
