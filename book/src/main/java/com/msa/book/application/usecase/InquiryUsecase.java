package com.msa.book.application.usecase;

import com.msa.book.framework.web.dto.output.BookOutPutDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryUsecase {
    public BookOutPutDTO getBookInfo(long bookNo);

}
