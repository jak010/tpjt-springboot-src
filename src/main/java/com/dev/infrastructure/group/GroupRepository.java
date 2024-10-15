package com.dev.infrastructure.group;


import com.dev.domain.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository extends JpaRepository<Group, Long> {

    Group save(Group group);

    Group findByGroupId(Long groupId);


}
