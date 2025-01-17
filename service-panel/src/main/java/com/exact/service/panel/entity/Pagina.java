	package com.exact.service.panel.entity;

import java.io.Serializable;
import java.util.List;

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

	private String descripcioncolor;	
	
	public String getDescripcioncolor() {
		return descripcioncolor;
	}

	public void setDescripcioncolor(String descripcioncolor) {
		this.descripcioncolor = descripcioncolor;
	}

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



	
	
	
}
