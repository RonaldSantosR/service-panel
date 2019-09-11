package com.exact.service.panel.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.panel.entity.Item;
import com.exact.service.panel.service.interfaces.IItemservice;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	IItemservice itemservice;
	
	@GetMapping()
	public ResponseEntity<Iterable<Item>> listarItem() {
		return  new ResponseEntity<>(itemservice.listarItems(),HttpStatus.OK);
	}
	
	@GetMapping("/activos")
	public ResponseEntity<Iterable<Item>> listarItemsActivos() throws IOException {
		return  new ResponseEntity<>(itemservice.listarItemsActivos(),HttpStatus.OK);
	}
	
	@PutMapping("/{id}/desactivar")
	public ResponseEntity<?> desactivarItem(@PathVariable Long id){
		Map<String, Object> respuesta = new HashMap<>();
		Item itemDesactivado = itemservice.desactivarItem(id);
		if(itemDesactivado==null) {
			respuesta.put("mensaje", "No se pudo desactivar el item");	
			return new ResponseEntity<>(respuesta,HttpStatus.BAD_REQUEST);
		}
		respuesta.put("mensaje", "Se desactivó el item");
		return new ResponseEntity<>(respuesta,HttpStatus.OK);
	}
	
	@PutMapping("/{id}/orden/{orden}")
	public ResponseEntity<Iterable<Item>> cambiarOrden(@PathVariable Long id, @PathVariable int orden){
		return new ResponseEntity<>(itemservice.cambiarOrdenItem(id, orden),HttpStatus.OK);
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<?> modificarItem(@RequestBody Item item){
		Map<String, Object> respuesta = new HashMap<>();
		String mensajeItem = itemservice.modificarItem(item);
		if(mensajeItem==null) {
			respuesta.put("mensaje", "No se pudo modificar el item");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		respuesta.put("mensaje", mensajeItem);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Map<String, Object>> guadarItem(@RequestBody Item item) {
		
		String rpta="";
		HttpStatus status = HttpStatus.OK;
		Map<String, Object> respuesta = new HashMap<>();
	
		switch(itemservice.agregarItem(item)) {
		case 0 :
			rpta="No se pudo registrar correctamente";
			status=HttpStatus.BAD_REQUEST;
			break;
		case 1 :
			rpta="se registró correctamente";
			status=HttpStatus.OK;
			break;
		}
		
		respuesta.put("mensaje", rpta);	
		return new ResponseEntity<>(respuesta,status);
	}	
	
	
}
