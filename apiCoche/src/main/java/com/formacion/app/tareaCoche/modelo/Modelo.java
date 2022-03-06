package com.formacion.app.tareaCoche.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "modelos")
public class Modelo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idmodelo;
	
	@Column(nullable = false, unique = true)
	private String nombre;
	
	

	// Getter y Setter
	public Long getIdmodelo() {
		return idmodelo;
	}

	public void setIdmodelo(Long idmodelo) {
		this.idmodelo = idmodelo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
