package com.formacion.app.tareaCoche.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idmarca;
	
	@Column(nullable = false, unique = true)
	private String nombre;
	
	
	
	//Getter y Setter
	public Long getIdmarca() {
		return idmarca;
	}
	public void setIdmarca(Long idmarca) {
		this.idmarca = idmarca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
