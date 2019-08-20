package com.exact.service.panel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.panel.entity.Pagina;

@Repository
public interface IPaginaDao extends CrudRepository<Pagina, Long>{

	
	
}
