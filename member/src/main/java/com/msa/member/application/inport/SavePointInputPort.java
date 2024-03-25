package com.msa.member.application.inport;


import com.msa.member.application.outport.MemberOutputPort;
import com.msa.member.application.usecase.SavePointUsecase;
import com.msa.member.domain.model.Member;
import com.msa.member.domain.model.vo.IDName;
import com.msa.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
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
