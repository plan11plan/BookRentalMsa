package com.msa.member.domain.event;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Item {
    private Long no;
    private String title;

    public static Item Sample(){
        return new Item(1L,"피노키오");
    }


}
