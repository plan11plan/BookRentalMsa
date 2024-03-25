package com.msa.book.framework.web.dto.input;

import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;

@Data
public class BookInfoDTO {

    private String title;
    private String description;
    private String author;
    private String isbn;
    private LocalDate publicationDate;
    private String source;
    private String classification;
    private String location;
}
