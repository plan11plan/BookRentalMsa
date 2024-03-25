package com.msa.bestBook.domain.event;


import com.msa.bestBook.domain.model.vo.Item;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRented implements Serializable {
    private IDName idName;
    private Item item;

    private Long point;
}
