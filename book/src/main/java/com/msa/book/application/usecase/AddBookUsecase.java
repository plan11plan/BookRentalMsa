package com.msa.book.application.usecase;

import com.msa.book.framework.web.dto.input.BookInfoDTO;
import com.msa.book.framework.web.dto.output.BookOutPutDTO;

public interface AddBookUsecase {
    /**
     * 도서를 입고상태로 생성한 뒤 저장처리
     */
    public BookOutPutDTO addBook(BookInfoDTO bookInfoDTO);
}
