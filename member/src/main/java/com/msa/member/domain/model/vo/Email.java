package com.msa.member.domain.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    public String address;

    public static Email sample() {
        return new Email("blank@gmail.com");
    }
}
