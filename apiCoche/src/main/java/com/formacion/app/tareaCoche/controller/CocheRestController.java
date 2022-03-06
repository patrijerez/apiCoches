package com.formacion.app.tareaCoche.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.app.tareaCoche.modelo.Coche;
import com.formacion.app.tareaCoche.modelo.Marca;
import com.formacion.app.tareaCoche.modelo.Modelo;
import com.formacion.app.tareaCoche.servicio.ServicioCoche;

@RestController
@RequestMapping("/api")
public class CocheRestController {

	@Autowired
	private ServicioCoche servicio;

	@GetMapping("/coches")
	public List<Coche> index() {
		return servicio.findAll();
	}

	@GetMapping("/coches/{id}") // Paso el id en la dirección
	public ResponseEntity<?> findCocheById(@PathVariable Long id) {

		Coche coche = null;
		Map<String, Object> response = new HashMap<>();

		try {

			coche = servicio.findById(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al reallizar consulta a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		if (coche == null) {
			response.put("mensaje", "El coche con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Coche>(coche, HttpStatus.OK);
	}

	@PostMapping("/coche/guardarCoche")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> saveCoche(@RequestBody Coche coche) {
		Map<String, Object> response = new HashMap<>();

		try {
			servicio.save(coche);
		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar la insert a la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "¡El coche ha sido creado con exito!");
		response.put("coche", coche);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping("/coche/upDateCoche/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> upDateCoche(@RequestBody Coche coche, @PathVariable Long id) {

		Coche cocheActual = servicio.findById(id);

		Map<String, Object> response = new HashMap<>();

		if (cocheActual == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			cocheActual.setId(id);
			cocheActual.setMarca(coche.getMarca());
			cocheActual.setModelo(coche.getModelo());
			cocheActual.setColor(coche.getColor());
			cocheActual.setMatricula(coche.getMatricula());
			cocheActual.setCilindrada(coche.getCilindrada());
			cocheActual.setVelocidad(coche.getVelocidad());

			servicio.save(cocheActual);
		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar la actualización a la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "¡El coche ha sido actualizado con exito!");
		response.put("coche", cocheActual);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@DeleteMapping("/coches/deleteCoche/{id}")
	public ResponseEntity<?> deleteCoche(@PathVariable Long id) {

		Coche cocheABorrar = servicio.findById(id);

		Map<String, Object> response = new HashMap<>();

		if (cocheABorrar == null) {
			response.put("mensaje", "El coche con ID: ".concat(id.toString().concat(" no se pudo eliminar")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			servicio.delete(id);

		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar la eliminación en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "¡El coche ha sido borrado con exito!");
		response.put("coche", cocheABorrar);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/coches/marcas")
	public List<Marca> listarMarcas() {
		return servicio.findAllMarcas();
	}

	@GetMapping("/coches/modelos")
	public List<Modelo> listarModelos() {
		return servicio.findAllModelos();
	}

}
