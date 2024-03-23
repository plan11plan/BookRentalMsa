package com.msa.member.framework.web.dto;

import com.msa.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MemberOutputDTO {
    private String id;
    private String Name;
    private String password;
    private String email;
    private long point;
    public static  MemberOutputDTO mapToDTO(Member member){
        MemberOutputDTO meberOutPutDTO = new MemberOutputDTO();
        meberOutPutDTO.setId(member.getIdName().getId());
        meberOutPutDTO.setName(member.getIdName().getName());
        meberOutPutDTO.setPassword(member.getPassword().getPresentPwD());
        meberOutPutDTO.setEmail(member.getEmail().getAddress());
        meberOutPutDTO.setPoint(member.getPoint().getPointValue());
        return meberOutPutDTO;
    }
}