package com.msa.rental.application.usecase;


import com.msa.rental.framework.web.dto.input.UserInputDTO;
import com.msa.rental.framework.web.dto.output.RentalCardOutputDTO;

public interface CreateRentalCardUsecase {
    public RentalCardOutputDTO createRentalCard(UserInputDTO userInputDTO);
}
