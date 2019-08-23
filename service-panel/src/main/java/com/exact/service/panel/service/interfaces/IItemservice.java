package com.exact.service.panel.service.interfaces;

import com.exact.service.panel.entity.Item;

public interface IItemservice {
		
	public Iterable<Item> listaritem();
	public Item agregarItem(Item item);
}
