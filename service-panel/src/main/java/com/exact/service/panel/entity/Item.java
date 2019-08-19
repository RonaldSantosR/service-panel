package com.exact.service.panel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long id;

	private String nombre;
	
	private String descripcion;
	
	private String ruta_imagen;
	
	private String orden;
	
	private String color;
	
	private String link_ruta;



	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tipo_item_id")
	private Tipo_Item tipo_item;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRuta_imagen() {
		return ruta_imagen;
	}

	public void setRuta_imagen(String ruta_imagen) {
		this.ruta_imagen = ruta_imagen;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLink_ruta() {
		return link_ruta;
	}

	public void setLink_ruta(String link_ruta) {
		this.link_ruta = link_ruta;
	}

	public Tipo_Item getTipo_item() {
		return tipo_item;
	}

	public void setTipo_item(Tipo_Item tipo_item) {
		this.tipo_item = tipo_item;
	}
	
	
	
}
