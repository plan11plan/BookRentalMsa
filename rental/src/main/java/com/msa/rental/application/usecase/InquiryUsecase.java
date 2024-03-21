package com.msa.rental.application.usecase;

import com.msa.rental.framework.web.dto.input.UserInputDTO;
import com.msa.rental.framework.web.dto.output.RentItemOutputDTO;
import com.msa.rental.framework.web.dto.output.RentalCardOutputDTO;
import com.msa.rental.framework.web.dto.output.ReturnItemOutputDTO;
import java.util.List;
import java.util.Optional;

public interface InquiryUsecase {

    public Optional<RentalCardOutputDTO> getRentalCard(UserInputDTO userInputDTO);
    public Optional<List<RentItemOutputDTO>> getAllRentItem(UserInputDTO userInputDTO);
    public Optional<List<ReturnItemOutputDTO>> getAllReturnItem(UserInputDTO userInputDTO);

}
