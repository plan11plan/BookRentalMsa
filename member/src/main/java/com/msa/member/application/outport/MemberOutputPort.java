package com.msa.member.application.outport;

import com.msa.member.domain.Member;
import com.msa.member.domain.vo.IDName;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberOutputPort {
    public Member loadMember(Long memberNo);
    public  Member loadMemberByIdName(IDName idName);
    public Member saveMember(Member member);
}