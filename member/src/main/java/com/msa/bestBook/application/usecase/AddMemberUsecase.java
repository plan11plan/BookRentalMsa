package com.msa.bestBook.application.usecase;

import com.msa.bestBook.framework.web.dto.MemberInfoDTO;
import com.msa.bestBook.framework.web.dto.MemberOutputDTO;

public interface AddMemberUsecase {
    public MemberOutputDTO addMember(MemberInfoDTO memberInfoDTO);
}