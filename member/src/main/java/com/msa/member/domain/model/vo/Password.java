package com.msa.member.domain.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Password {
    public String presentPwD;
    public String pastPwD;

    public static Password sample(){
        return new Password("12345","abcde");
    }
}
