package com.formacion.app.tareaCoche.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.tareaCoche.modelo.Modelo;

@Repository
public interface ModeloDAO extends CrudRepository<Modelo, Long> {

}
