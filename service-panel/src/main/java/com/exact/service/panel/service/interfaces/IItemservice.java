package com.exact.service.panel.service.interfaces;

import com.exact.service.panel.entity.Item;

public interface IItemservice {
		
	public Iterable<Item> listarItemsActivos();
	public Iterable<Item> listarItems();
	public int agregarItem(Item item);
	public Item desactivarItem(Long itemId);
	public Iterable<Item> cambiarOrdenItem(Long itemId, int orden);
	public Item modificarItem(Item item);
}
