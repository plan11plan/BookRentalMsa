package com.msa.book.domain.model;

import com.msa.book.domain.model.vo.BookDesc;
import com.msa.book.domain.model.vo.enumType.BookStatus;
import com.msa.book.domain.model.vo.enumType.Classification;
import com.msa.book.domain.model.vo.enumType.Location;
import com.msa.book.domain.model.vo.enumType.Source;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long no;
    private String title;
    @Embedded
    private BookDesc desc;
    private Classification classification;
    private BookStatus bookStatus;
    private LocalDate localDate;
    private Location location;
    public static Book enterBook(String title,
                                 String author,
                                 String isbn,
                                 String description,
                                 LocalDate publicationDate,
                                 Source source,
                                 Classification classification,
                                 Location location) {
        BookDesc bookDesc = BookDesc.createBookDesc(
                author,isbn,description,publicationDate,source);
        Book book = new Book();
        book.setTitle(title);
        book.setDesc(bookDesc);
        book.setClassification(classification);
        book.setLocation(location);
        book.setBookStatus(BookStatus.ENTERED);
        return book;
    }
    public static Book sample(){
        return enterBook("엔터프라이즈 아키텍처 패턴","마틴파울러","21321321","엔터프라이즈 패턴 에 관한 좋은 서적", LocalDate.now(),
                Source.SUPPLY,
                Classification.COMPUTER,
                Location.JEONGJA);
    }
    /**
     * 비즈니스 로직
     */

    public Book makeAvailable()
    {
        this.setBookStatus(BookStatus.AVAILABLE);
        return this;
    }
    public Book makeUnAvailable()
    {
        this.setBookStatus(BookStatus.AVAILABLE);
        return this;
    }



}
