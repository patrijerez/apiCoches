package com.formacion.app.tareaCoche.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.app.tareaCoche.modelo.Coche;
import com.formacion.app.tareaCoche.modelo.Marca;
import com.formacion.app.tareaCoche.modelo.Modelo;
import com.formacion.app.tareaCoche.repository.CocheDAO;
import com.formacion.app.tareaCoche.servicio.ServicioCoche;

@Service
public class ServicioCocheImpl implements ServicioCoche {

	@Autowired
	private CocheDAO cocheDao;

	@Override
	@Transactional(readOnly = true)
	public List<Coche> findAll() {
		return (List<Coche>) cocheDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Coche findById(Long id) {
		return cocheDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Marca> findAllMarcas() {
		return cocheDao.findAllMarcas();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Modelo> findAllModelos() {
		return cocheDao.findAllModelos();
	}

	@Override
	@Transactional
	public Coche save(Coche coche) {
		return cocheDao.save(coche);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		cocheDao.deleteById(id);
	}

	@Override
	@Transactional
	public Coche deleteConRetorno(Long id) {
		Coche c = cocheDao.findById(id).get();
		cocheDao.deleteById(id);
		return c;
	}

}
