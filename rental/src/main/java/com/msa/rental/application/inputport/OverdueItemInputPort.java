package com.msa.rental.application.inputport;


import com.msa.rental.application.outport.RentalCardOutputPort;
import com.msa.rental.application.usecase.OverdueItemUsecase;
import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.vo.Item;
import com.msa.rental.framework.web.dto.input.UserItemInputDTO;
import com.msa.rental.framework.web.dto.output.RentalCardOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OverdueItemInputPort implements OverdueItemUsecase {
    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalCardOutputDTO overDueItem(UserItemInputDTO rental) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(rental.userId)
                .orElseThrow(IllegalAccessError::new);
        rentalCard.overdueItem(new Item(rental.getItemId(), rental.getItemTitle()));
        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
