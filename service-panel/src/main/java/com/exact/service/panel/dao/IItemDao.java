package com.exact.service.panel.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.panel.entity.Item;

@Repository
public interface IItemDao extends CrudRepository<Item, Long>{
	
	@Query("SELECT Max(it.orden) FROM Item it")
	public int MayorOrden();

}
