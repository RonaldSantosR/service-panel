package com.exact.service.panel.service.clases;


import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.exact.service.panel.dao.IItemDao;
import com.exact.service.panel.entity.Item;
import com.exact.service.panel.entity.Tipo_Item;
import com.exact.service.panel.service.interfaces.IItemservice;


@Service
public class Itemservice implements IItemservice {
	
	@Autowired
	IItemDao itemdao;

	
	@Value("${ruta.logos}")
	String rutaLogo;
		
	@Override
	public Iterable<Item> listarItemsActivos() {
		Iterable<Item> items = itemdao.findAll();
		List<Item> itemlst = StreamSupport.stream(items.spliterator(), false).collect(Collectors.toList());
		itemlst.removeIf(item->!item.isActivo());
		return itemlst;
	}

	@Override
	public Item agregarItem(Item item) {
		item.setRuta_imagen(rutaLogo+item.getRuta_imagen());
		int ordenmayor = itemdao.MayorOrden();
		item.setOrden(ordenmayor+1);
		item.setActivo(true);
		item.setTipo_item(new Tipo_Item(1L));
		return itemdao.save(item);
	}

	@Override
	public Iterable<Item> listarItems() {
		return itemdao.findAll();
	}

	@Override
	public Item desactivarItem(Long itemId) {
		Optional<Item> itemopt = itemdao.findById(itemId);
		if(!itemopt.isPresent()) {
			return null;
		}
		Item item = itemopt.get();
		item.setActivo(false);
		
		return itemdao.save(item);
		
	}

	@Override
	public Iterable<Item> cambiarOrdenItem(Long itemId, int orden) {
		Optional<Item> itemopt = itemdao.findById(itemId);
		if(!itemopt.isPresent()) {
			return null;
		}
		Item item = itemopt.get();
		int ordenAnterior = item.getOrden();
		Iterable<Item> itemlst = itemdao.findAll();
		for(Item it : itemlst) {
			if(it.getOrden()==orden) {
			item.setOrden(it.getOrden());
			it.setOrden(ordenAnterior);
			}
		}
		itemdao.save(item);
		return itemdao.saveAll(itemlst);
		
	}
	
	public void cambiarorden(Long itemId, int orden) {
		Optional<Item> itemopt = itemdao.findById(itemId);
		Item item = itemopt.get();
		int ordenAnterior = item.getOrden();
		Iterable<Item> itemlst = itemdao.findAll();
		for(Item it : itemlst) {
			if(it.getOrden()==orden) {
			it.setOrden(ordenAnterior);
			itemdao.save(it);
			}
		}
	}
	

	@Override
	public Item modificarItem(Item item) {
		Optional<Item> itemopt = itemdao.findById(item.getId());
		
		if(!itemopt.isPresent()) {
			return null;
		}
		
		Item itemActualizado = itemopt.get();
		
		if(item.getDescripcion()!=null) {
			itemActualizado.setDescripcion(item.getDescripcion());
		}
		if(item.getColorTexto()!=null) {
			itemActualizado.setColorTexto(item.getColorTexto());
		}
		if(item.getNombre()!=null) {
			itemActualizado.setNombre(item.getNombre());
		}
		if(item.getRuta_imagen()!=null) {
			itemActualizado.setRuta_imagen(item.getRuta_imagen());
		}
		if(item.getLink_ruta()!=null) {
			itemActualizado.setLink_ruta(item.getLink_ruta());
		}
		
		cambiarorden(item.getId(),item.getOrden());
		
		itemActualizado.setOrden(item.getOrden());
		
		itemActualizado.setActivo(item.isActivo());
		
		return itemdao.save(itemActualizado);
	}

}
