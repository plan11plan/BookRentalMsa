package com.msa.rental.application.outport;

import com.msa.rental.domain.model.RentalCard;
import java.util.Optional;


// 애플리케이션층에서 필요한 입출력기능(DB기능)
public interface RentalCardOutputPort {

    Optional<RentalCard> loadRentalCard(String userId);

    RentalCard save(RentalCard rentalCard);
}
