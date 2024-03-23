package com.msa.bestBook.application.inport;

import com.msa.bestBook.application.outport.MemberOutputPort;
import com.msa.bestBook.application.usecase.UsePointUsecase;
import com.msa.bestBook.domain.Member;
import com.msa.bestBook.domain.vo.IDName;
import com.msa.bestBook.framework.web.dto.MemberOutputDTO;
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
