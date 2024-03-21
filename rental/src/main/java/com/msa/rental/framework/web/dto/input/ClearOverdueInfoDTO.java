package com.msa.rental.framework.web.dto.input;


import lombok.Data;

@Data
public class ClearOverdueInfoDTO {
    public String UserId;
    public String UserNm;
    public Long point;
}
