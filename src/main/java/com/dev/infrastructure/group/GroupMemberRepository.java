package com.dev.infrastructure.group;

import com.dev.domain.group.group_member.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {


}
