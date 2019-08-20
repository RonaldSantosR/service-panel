package com.exact.service.panel.service.clases;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.panel.dao.IItemDao;
import com.exact.service.panel.entity.Item;
import com.exact.service.panel.service.interfaces.IItemservice;


@Service
public class Itemservice implements IItemservice {
	
	@Autowired
	IItemDao itemdao;

	@Override
	public Iterable<Item> listaritem() {
		
		return itemdao.findAll();
	}

}
