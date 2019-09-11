package com.exact.service.panel.service.interfaces;

import java.io.IOException;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import com.exact.service.panel.entity.Item;

public interface IItemservice {
		

	public Iterable<Item> listarItemsActivos() throws IOException;
	public Iterable<Item> listarItems() throws IOException;
	public int agregarItem(Item item, MultipartFile file) throws IOException;
	public Item desactivarItem(Long itemId);
	public Iterable<Item> cambiarOrdenItem(Long itemId, int orden);
	public String modificarItem(Item item,  MultipartFile file) throws IOException;
	public List<Integer> listarOrdenItems();
}
