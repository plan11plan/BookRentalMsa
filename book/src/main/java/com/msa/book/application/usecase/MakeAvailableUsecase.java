package com.msa.book.application.usecase;

import com.msa.book.framework.web.dto.output.BookOutPutDTO;

public interface MakeAvailableUsecase {

    public BookOutPutDTO available(Long bookNo);
}
