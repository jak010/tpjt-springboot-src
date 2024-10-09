package com.dev.infrastructure.group;


import com.dev.domain.group.Group;
import com.dev.domain.group.GroupWriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group save(Group group);

}
