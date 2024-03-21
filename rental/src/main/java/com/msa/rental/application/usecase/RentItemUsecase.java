package com.msa.rental.application.usecase;


import com.msa.rental.framework.web.dto.input.UserItemInputDTO;
import com.msa.rental.framework.web.dto.output.RentalCardOutputDTO;

public interface RentItemUsecase {
    public RentalCardOutputDTO rentItem(UserItemInputDTO rental) throws
            Exception;
}
