package com.msa.rental.framework.web.dto.input;

import lombok.Data;

@Data
public class UserItemInputDTO {
    public String userId;
    public String userNm;
    public Long itemId;
    public String itemTitle;
}
