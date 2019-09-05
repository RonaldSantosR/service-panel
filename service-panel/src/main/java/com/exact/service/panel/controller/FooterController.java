package com.exact.service.panel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.panel.entity.Footer;
import com.exact.service.panel.service.interfaces.IFooterService;

@RestController
@RequestMapping("/footer")
public class FooterController {

	@Autowired
	IFooterService footerService;
	
	@GetMapping
	public ResponseEntity<Iterable<Footer>> listarFooter(){	
		return new ResponseEntity<Iterable<Footer>>(footerService.listarFooter(),HttpStatus.OK);
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<?> modificarFooter(@RequestBody Footer footer){
		Map<String, Object> respuesta = new HashMap<>();
		String mensajeFooter = footerService.modificarFooter(footer);
		if(mensajeFooter==null) {
			respuesta.put("mensaje", "No se pudo modificar");
			return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.OK);
		}
		respuesta.put("mensaje", mensajeFooter);
		return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.OK);
	}
	
}
