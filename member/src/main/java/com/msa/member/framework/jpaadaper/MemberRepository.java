package com.msa.member.framework.jpaadaper;

import com.msa.member.domain.Member;
import com.msa.member.domain.vo.IDName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    public Optional<Member> findMemberByIdName(IDName idName);
}
