package com.exact.service.panel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="pagina")
public class Pagina implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pagina_id")
	private Long id;
	
	private String color;
	
	private String titulo_color;
	
	private String titulo_texto;
	
	@OneToOne
	private Footer footer;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTitulo_color() {
		return titulo_color;
	}

	public void setTitulo_color(String titulo_color) {
		this.titulo_color = titulo_color;
	}

	public String getTitulo_texto() {
		return titulo_texto;
	}

	public void setTitulo_texto(String titulo_texto) {
		this.titulo_texto = titulo_texto;
	}

	public Footer getFooter() {
		return footer;
	}

	public void setFooter(Footer footer) {
		this.footer = footer;
	}
	
	
	
	
}
