package com.msa.book.application.usecase;

import com.msa.book.framework.web.dto.output.BookOutPutDTO;

public interface MakeUnAvailableUsecase {
    public BookOutPutDTO unavailable(long bookNo);}
