package com.msa.book.framework.web.dto.output;


import com.msa.book.domain.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookOutPutDTO {

    private Long bookNo;
    private String bookTitle;
    private String bookStatus;

    public static BookOutPutDTO mapToDTO(Book book){
        BookOutPutDTO bookOutPutDTO = new BookOutPutDTO();
        bookOutPutDTO.setBookNo(book.getNo());
        bookOutPutDTO.setBookTitle(book.getTitle());
        bookOutPutDTO.setBookStatus(book.getBookStatus().toString());
        return bookOutPutDTO;
    }
}
