package com.msa.bestBook.web;

import com.msa.bestBook.domain.BestBookService;
import com.msa.bestBook.domain.model.BestBook;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BestBookController {
    private final BestBookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BestBook>> getAllBooks() {
        List<BestBook> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BestBook> getBookById(@PathVariable("id") String id) {
        Optional<BestBook> bookOptional = bookService.getBookById(id);
        return bookOptional.map(book -> new ResponseEntity<>(book,
                        HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/books")
    public ResponseEntity<BestBook> createBook(@RequestBody BestBook book) {
        BestBook createdBook = bookService.saveBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BestBook> updateBook(@PathVariable("id") String id, @RequestBody BestBook book) {
        BestBook updatedBook = bookService.updateBook(id, book);
        return updatedBook != null ? new ResponseEntity<>(updatedBook, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

