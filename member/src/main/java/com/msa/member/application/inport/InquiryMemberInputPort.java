package com.msa.member.application.inport;


import com.msa.member.application.outport.MemberOutputPort;
import com.msa.member.application.usecase.InquiryMemberUsecase;
import com.msa.member.domain.Member;
import com.msa.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InquiryMemberInputPort implements InquiryMemberUsecase {
    private final MemberOutputPort memberOutPutPort;
    @Override
    public MemberOutputDTO getMember(long memberNo) {
        Member loadMember = memberOutPutPort.loadMember(memberNo);
        return MemberOutputDTO.mapToDTO(loadMember);
    }
}