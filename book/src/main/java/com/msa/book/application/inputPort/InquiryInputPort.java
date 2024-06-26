package com.msa.book.application.inputPort;

import com.msa.book.application.outputPort.BookOutPutPort;
import com.msa.book.application.usecase.InquiryUsecase;
import com.msa.book.domain.model.Book;
import com.msa.book.framework.web.dto.output.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InquiryInputPort implements InquiryUsecase {

    private final BookOutPutPort bookOutPutPort;

    @Override
    public BookOutPutDTO getBookInfo(long bookNo) {
        Book loadBook = bookOutPutPort.loadBook(bookNo);
        return BookOutPutDTO.mapToDTO(loadBook);
    }

}
