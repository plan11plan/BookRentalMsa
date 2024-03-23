package com.msa.bestBook.application.usecase;

import com.msa.bestBook.domain.vo.IDName;
import com.msa.bestBook.framework.web.dto.MemberOutputDTO;

public interface UsePointUsecase {
    public MemberOutputDTO userPoint(IDName idName, long point) throws Exception;
}
