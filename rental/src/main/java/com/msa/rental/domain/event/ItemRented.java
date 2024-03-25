package com.msa.rental.domain.event;

import com.msa.rental.domain.model.vo.IDName;
import com.msa.rental.domain.model.vo.Item;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ItemRented implements Serializable {
    private IDName idName;
    private Item item;

    private Long point;
}
