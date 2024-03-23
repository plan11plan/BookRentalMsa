package com.msa.bestBook.persistence;

import com.msa.bestBook.domain.model.BestBook;
import com.msa.bestBook.domain.model.vo.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestBookRepository extends MongoRepository<BestBook,String> {
    public BestBook findBestBookByItem(Item item);
}