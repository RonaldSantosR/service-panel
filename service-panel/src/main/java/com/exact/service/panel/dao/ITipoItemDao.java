package com.exact.service.panel.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.panel.entity.Tipo_Item;

@Repository
public interface ITipoItemDao  extends CrudRepository<Tipo_Item, Long>{

	@Query("FROM Tipo_Item ti where ti.id = ?1")
	public Tipo_Item BuscarItembyID(Long id);

}
