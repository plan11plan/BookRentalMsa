package com.msa.rental.application.inputport;


import com.msa.rental.application.outport.RentalCardOutputPort;
import com.msa.rental.application.usecase.ReturnItemUsecase;
import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.vo.Item;
import com.msa.rental.framework.web.dto.input.UserItemInputDTO;
import com.msa.rental.framework.web.dto.output.RentalCardOutputDTO;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReturnItemInputPort implements ReturnItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    @Override
    public RentalCardOutputDTO returnItem(UserItemInputDTO returnDto) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(returnDto.userId)
                .orElseThrow(IllegalAccessError::new);

        Item returnItem = new Item(returnDto.getItemId(), returnDto.getItemTitle());
        RentalCard fixedRentalCard = rentalCard.returnItem(returnItem, LocalDate.now());
        rentalCardOutputPort.save(fixedRentalCard);
        return RentalCardOutputDTO.mapToDTO(fixedRentalCard);
    }
}
