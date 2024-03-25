package com.msa.member.framework.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberInfoDTO {
    private String id;
    private String name;
    private String passWord;
    private String email;
}
