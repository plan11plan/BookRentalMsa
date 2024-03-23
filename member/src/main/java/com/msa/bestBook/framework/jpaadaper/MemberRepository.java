package com.msa.bestBook.framework.jpaadaper;

import com.msa.bestBook.domain.Member;
import com.msa.bestBook.domain.vo.IDName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    public Optional<Member> findMemberByIdName(IDName idName);
}
