package com.dev.domain.group;

public interface GroupWriter {

    Group save(Group group); // Info 객체로 리턴처리할 것

    Group getGroup(Long groupId); // Info 객체로 리턴처리할 것

}
