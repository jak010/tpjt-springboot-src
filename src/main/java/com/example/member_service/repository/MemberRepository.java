package com.example.member_service.repository;

import com.example.member_service.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    MemberEntity findByMemberId(Long memberId);

    List<MemberEntity> findAllByMemberIdIn(List<Long> memberIds);


    void deleteByMemberId(Long memberId);


}
