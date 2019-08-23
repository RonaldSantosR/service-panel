package com.exact.service.panel.service.clases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.panel.dao.ITituloDao;
import com.exact.service.panel.entity.Titulo;
import com.exact.service.panel.service.interfaces.ITituloService;

@Service
public class TituloService implements ITituloService{

	@Autowired
	ITituloDao tituloDao;
	
	@Override
	public Iterable<Titulo> listarTitulo() {
		return tituloDao.findAll();
	}
}
