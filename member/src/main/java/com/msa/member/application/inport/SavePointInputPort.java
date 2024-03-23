package com.msa.member.application.inport;

import com.msa.member.application.outport.MemberOutputPort;
import com.msa.member.application.usecase.SavePointUsecase;
import com.msa.member.domain.Member;
import com.msa.member.domain.vo.IDName;
import com.msa.member.framework.web.dto.MemberOutputDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class SavePointInputPort implements SavePointUsecase {

    private final MemberOutputPort memberOutPutPort;
    @Override
    public MemberOutputDTO savePoint(IDName idName, Long point) {
        Member loadMember = memberOutPutPort.loadMemberByIdName(idName);
        loadMember.savePoint(point);
        return MemberOutputDTO.mapToDTO(loadMember);
    }

}
