package com.exact.service.panel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.panel.entity.Pagina;
import com.exact.service.panel.service.interfaces.IPaginaService;

@RestController
@RequestMapping("/pagina")
public class PaginaController {

	@Autowired
	IPaginaService paginaService;
	
	@GetMapping
	public ResponseEntity<Pagina> listarPaginaPrincipal(){
		return  new ResponseEntity<Pagina>(paginaService.listarPaginaPrincipal(),HttpStatus.OK);
	}
	
}
