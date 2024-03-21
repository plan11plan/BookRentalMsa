package com.msa.rental.application.inputport.inquiry;


import com.msa.rental.application.outport.RentalCardOutputPort;
import com.msa.rental.application.usecase.InquiryUsecase;
import com.msa.rental.framework.web.dto.input.UserInputDTO;
import com.msa.rental.framework.web.dto.output.RentItemOutputDTO;
import com.msa.rental.framework.web.dto.output.RentalCardOutputDTO;
import com.msa.rental.framework.web.dto.output.ReturnItemOutputDTO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class InquiryInputPort implements InquiryUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    @Override
    public Optional<RentalCardOutputDTO> getRentalCard(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.getUserId())
                .map(RentalCardOutputDTO::mapToDTO);
    }

    @Override
    public Optional<List<RentItemOutputDTO>> getAllRentItem(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.getUserId())
                .map(i-> i.getRentalItemList()
                        .stream()
                        .map(RentItemOutputDTO::mapToDTO)
                        .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<ReturnItemOutputDTO>> getAllReturnItem(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.getUserId())
                .map(i -> i.getReturnItemList()
                .stream()
                .map(ReturnItemOutputDTO::mapToDTO)
                .collect(Collectors.toList()));
    }
}
