package com.dev.infrastructure.group.group_member;

import com.dev.domain.group.group_member.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {

    GroupMember save(GroupMember groupMember);

}
