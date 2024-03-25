package com.msa.member.domain.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class IDName {
    private String id;
    private String name;

    public static IDName sample(){
        return new IDName("sampleID","sampleName");
    }

    public static void main(String[] args) {
        System.out.println(sample().toString());
    }
}
