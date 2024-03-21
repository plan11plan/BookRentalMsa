package com.msa.book.application.outputPort;

import com.msa.book.domain.model.Book;
import org.springframework.stereotype.Repository;


@Repository
public interface BookOutPutPort {

    public Book loadBook(Long bookNo);
    public Book save(Book book);

}
