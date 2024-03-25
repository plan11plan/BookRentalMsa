package com.msa.rental.application.outport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.msa.rental.domain.event.ItemRented;
import com.msa.rental.domain.event.ItemReturned;
import com.msa.rental.domain.event.OverdueCleared;
import org.springframework.stereotype.Repository;


@Repository
public interface EventOutputPort {

    public void occurRentalEvent(ItemRented itemRented) throws JsonProcessingException;

    public void occurReturnedEvent(ItemReturned itemReturned) throws JsonProcessingException;
    public void occurOverdueClearedEvent(OverdueCleared overdueCleared) throws  JsonProcessingException;

}
