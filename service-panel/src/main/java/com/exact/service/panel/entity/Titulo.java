package com.exact.service.panel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="titulo")
public class Titulo implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "titulo_id")
	private Long id;
	
	private String texto;
	
	@Column(name="color_alto")
	private String colorAlto;
	
	@Column(name="color_medio")
	private String colorMedio;
	
	@Column(name="color_bajo")
	private String colorBajo;
	
	private String opacidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColorAlto() {
		return colorAlto;
	}

	public void setColorAlto(String colorAlto) {
		this.colorAlto = colorAlto;
	}

	public String getColorMedio() {
		return colorMedio;
	}

	public void setColorMedio(String colorMedio) {
		this.colorMedio = colorMedio;
	}

	public String getColorBajo() {
		return colorBajo;
	}

	public void setColorBajo(String colorBajo) {
		this.colorBajo = colorBajo;
	}

	public String getOpacidad() {
		return opacidad;
	}

	public void setOpacidad(String opacidad) {
		this.opacidad = opacidad;
	}
	
		
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
