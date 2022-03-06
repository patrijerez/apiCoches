package com.formacion.app.tareaCoche.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.tareaCoche.modelo.Coche;
import com.formacion.app.tareaCoche.modelo.Marca;
import com.formacion.app.tareaCoche.modelo.Modelo;

@Repository

public interface CocheDAO extends CrudRepository<Coche, Long> {

	// Para poder usar este método aquí (ya que es propio de otro repositorio):

	@Query("from Marca")
	public List<Marca> findAllMarcas();

	@Query("from Modelo")
	public List<Modelo> findAllModelos();

}
