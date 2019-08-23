package com.exact.service.panel.service.clases;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.panel.dao.IFooterDao;
import com.exact.service.panel.dao.IItemDao;
import com.exact.service.panel.dao.IPaginaDao;
import com.exact.service.panel.dao.ITituloDao;
import com.exact.service.panel.entity.Item;
import com.exact.service.panel.entity.Pagina;
import com.exact.service.panel.entity.Titulo;
import com.exact.service.panel.service.interfaces.IPaginaService;

@Service
public class PaginaService implements IPaginaService {

	@Autowired
	IPaginaDao paginaDao;
	
	@Autowired
	IItemDao itemDao;
	
	@Autowired
	ITituloDao tituloDao;
	
	@Autowired
	IFooterDao footerDao;
	
	@Override
	public Map<Integer,Object> listarPaginaPrincipal() {

		Iterable<Titulo> titulos = tituloDao.findAll();
		Iterable<Item> items = itemDao.findAll();
		Map<Integer,Object> vistaPrincipal = new HashMap<>();
		
		vistaPrincipal.put(1, titulos);
		vistaPrincipal.put(2, items);
		
		return vistaPrincipal;
		
	}

	
	
}
