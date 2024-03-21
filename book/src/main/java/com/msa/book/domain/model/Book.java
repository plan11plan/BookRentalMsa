package com.msa.book.domain.model;

import com.msa.book.domain.model.vo.BookDesc;
import com.msa.book.domain.model.vo.enumType.BookStatus;
import com.msa.book.domain.model.vo.enumType.Classfication;
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
    private Classfication classfication;
    private BookStatus bookStatus;
    private LocalDate localDate;
    private Location location;
    public static Book enterBook(String title,
                                 String author,
                                 String isbn,
                                 String description,
                                 LocalDate publicationDate,
                                 Source source,
                                 Classfication classfication,
                                 Location location) {
        BookDesc bookDesc = BookDesc.createBookDesc(
                author,isbn,description,publicationDate,source);
        Book book = new Book();
        book.setTitle(title);
        book.setDesc(bookDesc);
        book.setClassfication(classfication);
        book.setLocation(location);
        book.setBookStatus(BookStatus.ENTERED);
        return book;
    }
    public static Book sample(){
        return enterBook("엔터프라이즈 아키텍처 패턴","마틴파울러","21321321","엔터프라이즈 패턴 에 관한 좋은 서적", LocalDate.now(),
                Source.SUPPLY,
                Classfication.COMPUTER,
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
    public Book makeUnavailabe()
    {
        this.setBookStatus(BookStatus.AVAILABLE);
        return this;
    }



}
