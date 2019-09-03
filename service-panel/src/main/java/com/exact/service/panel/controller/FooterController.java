package com.exact.service.panel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PutMapping("/modificar")
	public ResponseEntity<Footer> modificarFooter(@RequestBody Footer footer){
		return new ResponseEntity<>(footerService.modificarFooter(footer),HttpStatus.OK);
	}
	
}
