package com.msa.rental.application.inputport;


import com.msa.rental.application.outport.RentalCardOutputPort;
import com.msa.rental.application.usecase.CreateRentalCardUsecase;
import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.vo.IDName;
import com.msa.rental.framework.web.dto.input.UserInputDTO;
import com.msa.rental.framework.web.dto.output.RentalCardOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class CreateRentalCardInputPort implements CreateRentalCardUsecase {

    /**
     * 우선 아웃풋 포트가 있어야함.
     * 렌탈카드라는 도메인 얘를 로딩해야함
     * 그 렌탈카드에게 비즈니스로직을 위임해야함 . 이후 그 도메인을 저장 .
     */

    private final RentalCardOutputPort rentalCardOutputPort; // 애플리케이션층에서 필요한 입출력 담당
    @Override
    public RentalCardOutputDTO createRentalCard(UserInputDTO owner) {
        RentalCard rentalCard = RentalCard.createRentalCard(new IDName(owner.getUserId(), owner.getUserNm()));
        RentalCard save = rentalCardOutputPort.save(rentalCard);
        return RentalCardOutputDTO.mapToDTO(save);
    }
}
