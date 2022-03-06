package com.formacion.app.tareaCoche.servicio;

import java.util.List;

import com.formacion.app.tareaCoche.modelo.Coche;
import com.formacion.app.tareaCoche.modelo.Marca;
import com.formacion.app.tareaCoche.modelo.Modelo;

public interface ServicioCoche {

	public List<Coche> findAll();

	public Coche findById(Long id);

	public List<Marca> findAllMarcas();

	public List<Modelo> findAllModelos();

	public Coche save(Coche coche);

	public void delete(Long id);

	public Coche deleteConRetorno(Long id);

}
