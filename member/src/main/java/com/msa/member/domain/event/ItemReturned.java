package com.msa.member.domain.event;


import com.msa.member.domain.model.vo.IDName;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class ItemReturned extends ItemRented{
    public ItemReturned(IDName idName, Item item,Long point) {super(idName, item, point);
    }
}
