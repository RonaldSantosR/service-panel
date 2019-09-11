package com.exact.service.panel.service.clases;




import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exact.service.panel.dao.IHandleFileEdao;
import com.exact.service.panel.dao.IItemDao;
import com.exact.service.panel.entity.Item;
import com.exact.service.panel.entity.Tipo_Item;
import com.exact.service.panel.service.interfaces.IItemservice;
import com.exact.service.panel.utils.ConvertImageToBase64;


@Service
public class Itemservice implements IItemservice {
	
	@Autowired
	IItemDao itemdao;

	
	@Value("${ruta.logos}")
	String rutaLogo;
	
	@Autowired
	IHandleFileEdao handleFileEdao;
		
	@Override
	public Iterable<Item> listarItemsActivos() throws IOException {
		Iterable<Item> items = itemdao.findAll();
		
		
		for(Item item : items) {
			String imagenB64=ConvertImageToBase64.encodeToString(item.getRuta_imagen());
			item.setRuta_imagen(imagenB64);
		}
		
		
		List<Item> itemlst = StreamSupport.stream(items.spliterator(), false).collect(Collectors.toList());
		itemlst.removeIf(item->!item.isActivo());
		return itemlst;
	}

	@Override
	public int  agregarItem(Item item, MultipartFile file) throws IOException {
		String ruta = "logos";
		try {
			if(item.getNombre().equals("") || item.getDescripcion().equals("") || item.getLink_ruta().equals("") || item.getTipo_item().equals(null) || file==null ) {
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
		String rutaImagen = item.getNombre()+"."+FilenameUtils.getExtension(file.getOriginalFilename());
		item.setRuta_imagen(rutaLogo+rutaImagen);
		MockMultipartFile multipartFile = new MockMultipartFile(rutaImagen, rutaImagen,
				file.getContentType(), file.getInputStream());
		if (handleFileEdao.upload(multipartFile,ruta) != 1) {
			return 0;
		}
		int ordenmayor = itemdao.MayorOrden();
		item.setOrden(ordenmayor+1);
		item.setActivo(true);
		itemdao.save(item);
		
		return 1;
	}

	@Override
	public Iterable<Item> listarItems() throws IOException {
		Iterable<Item> items = itemdao.findAll();
		for(Item item : items) {
			String imagenB64=ConvertImageToBase64.encodeToString(item.getRuta_imagen());
			item.setRuta_imagen(imagenB64);
		}
		return items;
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
	public String modificarItem(Item item, MultipartFile file) throws IOException {
		String ruta = "logos";
		Optional<Item> itemopt = itemdao.findById(item.getId());
		
		if(!itemopt.isPresent()) {
			return "Item no encontrado";
		}
		
		Item itemActualizado = itemopt.get();
		
		if(item.getNombre()!=null) {
			itemActualizado.setNombre(item.getNombre());
		}
		
		if(item.getDescripcion()!=null) {
			itemActualizado.setDescripcion(item.getDescripcion());
		}
		
		if(item.getLink_ruta()!=null) {
			itemActualizado.setLink_ruta(item.getLink_ruta());
		}
		
		if(item.getVideo()!=null) {
			itemActualizado.setVideo(item.getVideo());
		}
		
		if(item.getOrden()!=0) {
			cambiarorden(item.getId(),item.getOrden());
			itemActualizado.setOrden(item.getOrden());
		}
		
		if(file!=null) {
			String rutaImagen = item.getNombre()+"."+FilenameUtils.getExtension(file.getOriginalFilename());
			itemActualizado.setRuta_imagen(rutaLogo+rutaImagen);
			MockMultipartFile multipartFile = new MockMultipartFile(rutaImagen, rutaImagen,
					file.getContentType(), file.getInputStream());
			if (handleFileEdao.upload(multipartFile,ruta) != 1) {
				return "No se actualizó la imagen";
			}
		}
		
		itemdao.save(itemActualizado);
		return "Se modificó el item";
	}

	@Override
	public List<Integer> listarOrdenItems() {
		Iterable<Item> items = itemdao.findAll();
		List<Integer> ordenItems = new ArrayList<>();
		
		for(Item item: items) {
			ordenItems.add(item.getOrden());
		}
		
		return ordenItems;
	}

}
