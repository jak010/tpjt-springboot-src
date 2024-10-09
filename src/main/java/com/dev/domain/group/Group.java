package com.dev.domain.group;

import com.dev.domain.AbstractEntity;
import com.dev.domain.member.Member;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.PERSIST)
    private List<Member> memberList = Lists.newArrayList();

    @Builder
    public Group(String groupName) {
        this.groupName = groupName;
    }

}
