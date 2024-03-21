package com.msa.rental.framework.jpaadapter;


import com.msa.rental.application.outport.RentalCardOutputPort;
import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.framework.jpaadapter.repository.RentalCardRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class RentalCardJpaAdapter implements RentalCardOutputPort {
    private final RentalCardRepository rentalCardRepository;
    @Override
    public Optional<RentalCard> loadRentalCard(String userId) {
        return rentalCardRepository.findByMemberId(userId);
    }

    @Override
    public RentalCard save(RentalCard rentalCard) {
        return rentalCardRepository.save(rentalCard);
    }
}
