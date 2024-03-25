package com.msa.book.application.inputPort;

import com.msa.book.application.outputPort.BookOutPutPort;
import com.msa.book.application.usecase.AddBookUsecase;
import com.msa.book.domain.model.Book;
import com.msa.book.domain.model.vo.enumType.Classification;
import com.msa.book.domain.model.vo.enumType.Location;
import com.msa.book.domain.model.vo.enumType.Source;
import com.msa.book.framework.web.dto.input.BookInfoDTO;
import com.msa.book.framework.web.dto.output.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddBookInputPort implements AddBookUsecase {

    private final BookOutPutPort bookOutPutPort;

    @Override
    public BookOutPutDTO addBook(BookInfoDTO bookInfoDTO) {
        Book book = Book.enterBook(
                bookInfoDTO.getTitle(),
                bookInfoDTO.getAuthor(),
                bookInfoDTO.getIsbn(),
                bookInfoDTO.getDescription(),
                bookInfoDTO.getPublicationDate(),
                Source.valueOf(bookInfoDTO.getSource()),
                Classification.valueOf(bookInfoDTO.getClassification()),
                Location.valueOf(bookInfoDTO.getLocation())
        );
        bookOutPutPort.save(book);
        return BookOutPutDTO.mapToDTO(book);
    }
}
