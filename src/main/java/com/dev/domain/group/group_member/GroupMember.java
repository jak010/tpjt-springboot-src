package com.dev.domain.group.group_member;

import com.dev.domain.AbstractEntity;
import com.dev.domain.group.Group;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;

@Table(name = "group_member", uniqueConstraints = {
        @UniqueConstraint(
                name = "GROUP_MEBMER_UNIQUE_CONSTRAINT",
                columnNames = {"group_id", "member_id"}
        )
})
//@Table(name = "group_member")
@Entity
@Getter
@NoArgsConstructor
public class GroupMember extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "member_id")
    private Long memberId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "joinedAt")
    private ZonedDateTime joinedAt;


    @Builder
    public GroupMember(Group group, Long memberId) {
        this.group = group;
        this.memberId = memberId;
        this.status = Status.ACIVATE;
        this.joinedAt = ZonedDateTime.now();

    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        DEACTIVE("비활성"), ACIVATE("활성");

        private final String description;
    }

}
