package com.msa.book.framework.jpaAdapter;


import com.msa.book.application.outputPort.BookOutPutPort;
import com.msa.book.domain.model.Book;
import com.msa.book.framework.jpaAdapter.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookJpaAdapter implements BookOutPutPort {
    private final BookRepository bookRepository;

    @Override
    public Book loadBook(Long bookNo) {
        return bookRepository.findById(bookNo).get();
    }

    @Override
    public Book save(Book book) {
        Book save = bookRepository.save(book);
        return save;
    }
}
