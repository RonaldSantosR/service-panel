package com.exact.service.panel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		return  new ResponseEntity<Iterable<Item>>(itemservice.listaritem(),HttpStatus.OK);
	}
}
