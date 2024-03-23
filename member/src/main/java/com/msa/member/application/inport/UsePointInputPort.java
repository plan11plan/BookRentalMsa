package com.msa.member.application.inport;

import com.msa.member.application.outport.MemberOutputPort;
import com.msa.member.application.usecase.UsePointUsecase;
import com.msa.member.domain.Member;
import com.msa.member.domain.vo.IDName;
import com.msa.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UsePointInputPort implements UsePointUsecase {
    private final MemberOutputPort memberOutPutPort;

    @Override
    public MemberOutputDTO userPoint(IDName idName, long point) throws
            Exception {
        Member loadMember = memberOutPutPort.loadMemberByIdName(idName);
        loadMember.usePoint(point);
        return MemberOutputDTO.mapToDTO(loadMember);
    }
}
