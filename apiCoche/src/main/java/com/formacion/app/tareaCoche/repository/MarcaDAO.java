package com.formacion.app.tareaCoche.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.tareaCoche.modelo.Marca;

@Repository
public interface MarcaDAO extends CrudRepository<Marca, Long> {

}
