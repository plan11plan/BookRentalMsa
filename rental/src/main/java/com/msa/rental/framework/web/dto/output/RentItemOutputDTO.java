package com.msa.rental.framework.web.dto.output;

import com.msa.rental.domain.model.RentalItem;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentItemOutputDTO {
    private Long itemNo;
    private String itemtitle;
    private LocalDate rentDate; private boolean overdued; //반납 예정일
    private LocalDate overdueDate;
    public static RentItemOutputDTO mapToDTO(RentalItem rentItem)
    {
        RentItemOutputDTO rentItemOutputDTO = new RentItemOutputDTO();
        rentItemOutputDTO.setItemNo(rentItem.getItem().getNo());
        rentItemOutputDTO.setItemtitle(rentItem.getItem().getTitle());
        rentItemOutputDTO.setRentDate(rentItem.getRentDate());
        rentItemOutputDTO.setOverdued(rentItem.isOverdued());
        rentItemOutputDTO.setOverdueDate(rentItem.getOverdueDate());
        return rentItemOutputDTO;
    }


}
