package com.dev.domain.group;

import com.dev.domain.AbstractEntity;
import com.dev.domain.group.group_member.GroupMember;
import com.google.common.collect.Lists;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Table(name = "`group`")
@NoArgsConstructor
@ToString
public class Group extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_name")
    private String groupName;


    // 연관관계의 주인이 되는 쪽에 mappedBy 속성 설정
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.PERSIST)
    private final List<GroupMember> groupMembers = Lists.newArrayList();


    @Builder
    public Group(String groupName) {
        this.groupName = groupName;
    }

    public int getMemberTotal() {
        return groupMembers.size();
    }

}
