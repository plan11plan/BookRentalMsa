package com.msa.book.domain.event;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRented implements Serializable {
    private IDName idName;
    private Item item;

    private Long point;
}
