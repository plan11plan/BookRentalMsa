package com.msa.member.framework.jpaadaper;

import com.msa.member.application.outport.MemberOutputPort;
import com.msa.member.domain.Member;
import com.msa.member.domain.vo.IDName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class MemberJpaAdapter implements MemberOutputPort {
    private  final MemberRepository memberRepository;
    @Override
    public Member loadMember(Long memberNo) {
       return memberRepository.findById(memberNo).get();
    }

    @Override
    public Member loadMemberByIdName(IDName idName) {
        return memberRepository.findMemberByIdName(idName).get();
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
