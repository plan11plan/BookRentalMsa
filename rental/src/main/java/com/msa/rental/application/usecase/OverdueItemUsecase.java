package com.msa.rental.application.usecase;


import com.msa.rental.framework.web.dto.input.UserItemInputDTO;
import com.msa.rental.framework.web.dto.output.RentalCardOutputDTO;

public interface OverdueItemUsecase {

    public RentalCardOutputDTO overDueItem(UserItemInputDTO rental) throws Exception;
}
