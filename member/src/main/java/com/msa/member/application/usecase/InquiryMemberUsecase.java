package com.msa.member.application.usecase;

import com.msa.member.framework.web.dto.MemberOutputDTO;

public interface InquiryMemberUsecase {
    public MemberOutputDTO getMember(long memberNo);
}
