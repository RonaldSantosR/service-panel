package com.exact.service.panel.controller;

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
	public ResponseEntity<Iterable<Item>> listarItemsActivos() {
		return  new ResponseEntity<>(itemservice.listarItemsActivos(),HttpStatus.OK);
	}
	
	@PutMapping("/{id}/desactivar")
	public ResponseEntity<Item> desactivarItem(@PathVariable Long id){
		return new ResponseEntity<>(itemservice.desactivarItem(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}/orden/{orden}")
	public ResponseEntity<Iterable<Item>> cambiarOrden(@PathVariable Long id, @PathVariable int orden){
		return new ResponseEntity<>(itemservice.cambiarOrdenItem(id, orden),HttpStatus.OK);
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Item> modificarItem(@RequestBody Item item){
		return new ResponseEntity<Item>(itemservice.modificarItem(item),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Item> guadarItem(@RequestBody Item item) {
		return  new ResponseEntity<Item>(itemservice.agregarItem(item),HttpStatus.OK);
	}	
	
	
}
