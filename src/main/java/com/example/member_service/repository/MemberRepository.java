package com.example.member_service.repository;

import com.example.member_service.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    MemberEntity findByMemberId(Long memberId);

    void deleteByMemberId(Long memberId);


}
