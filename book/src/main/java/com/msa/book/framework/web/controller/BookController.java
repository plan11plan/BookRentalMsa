package com.msa.book.framework.web.controller;


import com.msa.book.application.usecase.AddBookUsecase;
import com.msa.book.application.usecase.InquiryUsecase;
import com.msa.book.application.usecase.MakeAvailableUsecase;
import com.msa.book.application.usecase.MakeUnAvailableUsecase;
import com.msa.book.framework.web.dto.input.BookInfoDTO;
import com.msa.book.framework.web.dto.output.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookController {
    private final AddBookUsecase addBookUsecase;
    private final MakeAvailableUsecase makeAvailableUsecase;
    private final MakeUnAvailableUsecase makeUnAvailableUsecase;
    private final InquiryUsecase inquiryUsecase;

    @PostMapping("/book")
    public ResponseEntity<BookOutPutDTO> createBook(@RequestBody BookInfoDTO bookInfoDTO){
        BookOutPutDTO bookOutPutDTO = addBookUsecase.addBook(bookInfoDTO);
        return new ResponseEntity<>(bookOutPutDTO, HttpStatus.CREATED);
    }

    @GetMapping("/book/{no}")
    public ResponseEntity<BookOutPutDTO> getBookNo(@PathVariable("no") Long no){
        BookOutPutDTO bookInfo = inquiryUsecase.getBookInfo(no);
        return bookInfo != null ? new ResponseEntity<>(bookInfo,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
