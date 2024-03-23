package com.msa.bestBook.application.usecase;

import com.msa.bestBook.framework.web.dto.MemberOutputDTO;

public interface InquiryMemberUsecase {
    public MemberOutputDTO getMember(long memberNo);
}
