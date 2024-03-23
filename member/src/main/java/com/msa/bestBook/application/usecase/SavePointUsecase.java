package com.msa.bestBook.application.usecase;

import com.msa.bestBook.domain.vo.IDName;
import com.msa.bestBook.framework.web.dto.MemberOutputDTO;

public interface SavePointUsecase {
    public MemberOutputDTO savePoint(IDName idName, Long point);

}
