package com.exact.service.panel.service.interfaces;

import java.io.IOException;

import com.exact.service.panel.entity.Item;

public interface IItemservice {
		
	public Iterable<Item> listarItemsActivos() throws IOException;
	public Iterable<Item> listarItems();
	public int agregarItem(Item item);
	public Item desactivarItem(Long itemId);
	public Iterable<Item> cambiarOrdenItem(Long itemId, int orden);
	public String modificarItem(Item item);
}
