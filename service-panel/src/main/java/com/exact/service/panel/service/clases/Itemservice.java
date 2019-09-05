package com.exact.service.panel.service.clases;




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
	public int  agregarItem(Item item) {
		
		try {
			if(item.getNombre().equals("") || item.getDescripcion().equals("") || item.getLink_ruta().equals("") || item.getTipo_item().equals(null) ) {
				return 0;
			}
		}catch(NullPointerException e) {
			return 0;
		}
		
		try {
			if(item.getTipo_item().getId() <=0L) {
				return 0;
			}

		}catch(NullPointerException e) {
			return 0;
		}

		item.setRuta_imagen(rutaLogo+item.getNombre());
		int ordenmayor = itemdao.MayorOrden();
		item.setOrden(ordenmayor+1);
		item.setActivo(true);


		itemdao.save(item);
		
		return 1;
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
	public String modificarItem(Item item) {
		Optional<Item> itemopt = itemdao.findById(item.getId());
		
		if(!itemopt.isPresent()) {
			return "Item no encontrado";
		}
		
		Item itemActualizado = itemopt.get();
		
		if(item.getDescripcion()!=null) {
			itemActualizado.setDescripcion(item.getDescripcion());
		}
		
		if(item.getNombre()!=null) {
			itemActualizado.setNombre(item.getNombre());
		}
		
		if(item.getRuta_imagen()!=null) {
			itemActualizado.setRuta_imagen(rutaLogo+item.getRuta_imagen());
		}
		
		if(item.getLink_ruta()!=null) {
			itemActualizado.setLink_ruta(item.getLink_ruta());
		}
		if(item.getTipo_item()!=null) {
			itemActualizado.setTipo_item(item.getTipo_item());
		}
		if(!itemActualizado.isActivo()) {
			itemActualizado.setActivo(true);
		}
		if(item.getOrden()!=0) {
			cambiarorden(item.getId(),item.getOrden());
			itemActualizado.setOrden(item.getOrden());
		}
		itemdao.save(itemActualizado);
		return "Se modificó el item";
	}

}
