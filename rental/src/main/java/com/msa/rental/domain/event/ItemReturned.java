package com.msa.rental.domain.event;

import com.msa.rental.domain.model.vo.IDName;
import com.msa.rental.domain.model.vo.Item;

public class ItemReturned extends ItemRented{
    public ItemReturned(IDName idName, Item item,
                        Long point) {
        super(idName, item, point);
    }
}
