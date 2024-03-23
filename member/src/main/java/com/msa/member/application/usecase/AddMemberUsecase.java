package com.msa.member.application.usecase;

import com.msa.member.framework.web.dto.MemberInfoDTO;
import com.msa.member.framework.web.dto.MemberOutputDTO;

public interface AddMemberUsecase {
    public MemberOutputDTO addMember(MemberInfoDTO memberInfoDTO);
}