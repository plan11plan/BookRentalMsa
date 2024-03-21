package com.msa.rental.application.usecase;


import com.msa.rental.framework.web.dto.input.UserItemInputDTO;
import com.msa.rental.framework.web.dto.output.RentalCardOutputDTO;

public interface ReturnItemUsecase {
    public RentalCardOutputDTO returnItem(UserItemInputDTO returnDto) throws Exception;

}
