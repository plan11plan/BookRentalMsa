package com.msa.bestBook.application.inport;

import com.msa.bestBook.application.outport.MemberOutputPort;
import com.msa.bestBook.application.usecase.SavePointUsecase;
import com.msa.bestBook.domain.Member;
import com.msa.bestBook.domain.vo.IDName;
import com.msa.bestBook.framework.web.dto.MemberOutputDTO;
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
