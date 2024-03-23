package com.msa.bestBook.application.outport;

import com.msa.bestBook.domain.Member;
import com.msa.bestBook.domain.vo.IDName;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberOutputPort {
    public Member loadMember(Long memberNo);
    public  Member loadMemberByIdName(IDName idName);
    public Member saveMember(Member member);
}