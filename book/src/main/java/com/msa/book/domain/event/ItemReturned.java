package com.msa.book.domain.event;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemReturned extends ItemRented{
    public ItemReturned(IDName idName, Item item,
                        Long point) {
        super(idName, item, point);
    }
}
