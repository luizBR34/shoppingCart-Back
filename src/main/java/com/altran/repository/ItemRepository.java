package com.altran.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.altran.model.Item;


@Repository
public interface ItemRepository extends CrudRepository<Item, String> {
		
}
