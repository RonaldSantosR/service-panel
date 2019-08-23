package com.exact.service.panel.service.clases;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.exact.service.panel.dao.IItemDao;
import com.exact.service.panel.entity.Item;
import com.exact.service.panel.service.interfaces.IItemservice;


@Service
public class Itemservice implements IItemservice {
	
	@Autowired
	IItemDao itemdao;

	
	@Value("${ruta.logos}")
	String rutaLogo;
		
	@Override
	public Iterable<Item> listaritem() {
		
		return itemdao.findAll();
	}

	@Override
	public Item agregarItem(Item item) {
		item.setRuta_imagen(rutaLogo+item.getNombre());
		return itemdao.save(item);
	}

}
