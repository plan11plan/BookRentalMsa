package com.msa.bestBook.application.inport;


import com.msa.bestBook.application.outport.MemberOutputPort;
import com.msa.bestBook.application.usecase.InquiryMemberUsecase;
import com.msa.bestBook.domain.Member;
import com.msa.bestBook.framework.web.dto.MemberOutputDTO;
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