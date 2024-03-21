package com.msa.book.application.inputPort;

import com.msa.book.application.outputPort.BookOutPutPort;
import com.msa.book.application.usecase.MakeUnAvailableUsecase;
import com.msa.book.domain.model.Book;
import com.msa.book.framework.web.dto.output.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MakeUnAvailableInputPort implements MakeUnAvailableUsecase {
    private final BookOutPutPort bookOutPutPort;

    @Override
    public BookOutPutDTO available(Long bookNo) {
        Book loadBook = bookOutPutPort.loadBook(bookNo);
        loadBook.makeUnavailabe();
        return BookOutPutDTO.mapToDTO(loadBook);
    }

}
