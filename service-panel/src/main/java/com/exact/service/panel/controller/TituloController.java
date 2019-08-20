package com.exact.service.panel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.panel.entity.Titulo;
import com.exact.service.panel.service.interfaces.ITituloService;

@RestController
@RequestMapping("/titulo")
public class TituloController {

	@Autowired
	ITituloService tituloService;
	
	@GetMapping
	public ResponseEntity<Iterable<Titulo>> listarTitulos(){
		return new ResponseEntity<>(tituloService.listarTitulo(),HttpStatus.OK);
	}
	
}
