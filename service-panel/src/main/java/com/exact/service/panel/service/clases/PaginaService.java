package com.exact.service.panel.service.clases;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.panel.dao.IPaginaDao;
import com.exact.service.panel.entity.Pagina;
import com.exact.service.panel.service.interfaces.IPaginaService;

@Service
public class PaginaService implements IPaginaService {

	@Autowired
	IPaginaDao paginaDao;
	
	
	@Override
	public Pagina listarPaginaPrincipal() {

		return null;
		
	}

	
	
}
