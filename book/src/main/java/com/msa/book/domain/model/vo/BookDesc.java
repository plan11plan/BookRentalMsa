package com.msa.book.domain.model.vo;

import com.msa.book.domain.model.vo.enumType.Source;
import jakarta.persistence.Embeddable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
도서상세 VO는 설명,저자,ISBN,출판일,출처로 구성됨. 출처는 enum
 */
@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class BookDesc {
    private String description;
    private String author;
    private String isbn;
    private LocalDate publicationDate;
    private Source source;

    public static BookDesc createBookDesc(String author,
                                          String isbn,
                                          String description,
                                          LocalDate publicationDate,
                                          Source source) {
        return new BookDesc(description, author, isbn, publicationDate,
                source);
    }

    public static BookDesc sample() {
        return createBookDesc("마틴파울러", "123456789",
                "엔터프라이즈 아키텍처 패턴을 설명", LocalDate.now(), Source.SUPPLY);
    }
}
