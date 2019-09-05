package com.exact.service.panel.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.panel.entity.Pagina;
import com.exact.service.panel.service.interfaces.IPaginaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/pagina")
public class PaginaController {

	@Autowired
	IPaginaService paginaService;
	
	@GetMapping
	public ResponseEntity<Map<Integer,Object>> listarPaginaPrincipal() throws IOException{
		return  new ResponseEntity<>(paginaService.listarPaginaPrincipal(),HttpStatus.OK);
	}
	
	
	@PutMapping("/modificar")
	public ResponseEntity<?> modificarPagina(@RequestBody Pagina pag) throws IOException{
		Pagina paginaModificada = paginaService.modificarPagina(pag);
		Map<String, Object> respuesta = new HashMap<>();
		if(paginaModificada==null) {
			respuesta.put("mensaje", "No se pudo modificar la página");
			return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.BAD_REQUEST);
		}
		respuesta.put("mensaje", "Se modificó la página");
		return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.OK);
	}
	
}
