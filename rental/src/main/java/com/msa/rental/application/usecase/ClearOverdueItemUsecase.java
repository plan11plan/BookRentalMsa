package com.msa.rental.application.usecase;


import com.msa.rental.framework.web.dto.input.ClearOverdueInfoDTO;
import com.msa.rental.framework.web.dto.output.RentalResultOutputDTO;

public interface ClearOverdueItemUsecase {
    public RentalResultOutputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception;
}
