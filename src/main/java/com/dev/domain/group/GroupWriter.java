package com.dev.domain.group;

import org.hibernate.validator.internal.engine.resolver.JPATraversableResolver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupWriter {

    Group save(Group group); // Info 객체로 리턴처리할 것

}
