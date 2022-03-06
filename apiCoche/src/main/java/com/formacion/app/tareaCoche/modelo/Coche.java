package com.formacion.app.tareaCoche.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "coches")
public class Coche implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Una marca tiene muchos coches
	@ManyToOne(fetch = FetchType.LAZY) // Especificar tipo de carga
	@JoinColumn(name = "idmarca") // Mapeo
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) //
	private Marca marca;
	
	// Un modelo tiene muchos coches
	@ManyToOne(fetch = FetchType.LAZY) // Especificar tipo de carga
	@JoinColumn(name = "idmodelo") // Mapeo
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) //
	private Modelo modelo;
	
	private String color;
	
	@Column(nullable = false, unique = true)
	private String matricula;
	
	private int cilindrada;
	
	private int velocidad;
	
	
	//Getter y Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	

}
