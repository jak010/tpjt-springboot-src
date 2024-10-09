package com.dev.domain.group;

import com.dev.domain.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

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

    @Builder
    public Group(String groupName) {
        this.groupName = groupName;
    }

}
