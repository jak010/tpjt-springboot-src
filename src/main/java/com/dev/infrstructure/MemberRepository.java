package com.dev.infrstructure;

import com.dev.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member save(Member initMember);

    Optional<Member> findByMemberId(Long mmeberId);

}
