package com.msa.rental.domain.model.vo;


import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
/**
 * 직렬화 : 객체의 상태를 영속화 하는 메커니즘
 * : 객체를 다른 환경에 저장했다가 나중에 재구성 할 수 있게 만드는 과정
 */
public class RentalCardNo implements Serializable {
    private String no;

    public static RentalCardNo createRentalCardNo(){
        UUID uuid = UUID.randomUUID();
        String year = String.valueOf(LocalDate.now().getYear());
        String str = year +'-' + uuid;
        RentalCardNo rentalCardNo = new RentalCardNo();
        rentalCardNo.setNo(str);
        return rentalCardNo;
    }

    public static RentalCardNo sample(){
        return RentalCardNo.createRentalCardNo();
    }
    public static void main(String[] args){
        System.out.println(">>");
        System.out.println(RentalCardNo.sample());
        System.out.println(">>");

    }
}
