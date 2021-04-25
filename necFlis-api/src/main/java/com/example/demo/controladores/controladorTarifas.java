package com.example.demo.controladores;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Tarifas;
import com.example.demo.repositorios.repositorioTarifas;

//Mostrar lista de planes 
@RestController
@RequestMapping(value = "/tarifas")
public class controladorTarifas {

	@Autowired
	repositorioTarifas repositorio;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)

	public Collection<Tarifas> getlistaTarifas() {
		Iterable<Tarifas> listaTarifas = repositorio.findAll();

		return (Collection<Tarifas>) listaTarifas;
	}

	// Buscar plan

	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Tarifas getTarifas(@PathVariable(name = "id") Long id) {

		Optional<Tarifas> tarifa = repositorio.findById(id);

		Tarifas resultado = null;
		if (tarifa.isPresent()) {
			resultado = tarifa.get();
		}
		return resultado;
	}

	// Crear plan
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tarifas crearTarifa(@RequestBody Tarifas tarifa) {
		Tarifas nuevaTarifa = repositorio.save(tarifa);
		return nuevaTarifa;

	}

	// Borrar plan

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)

	public void borrarTarifa(@PathVariable(name = "id") Long id) {
		repositorio.deleteById(id);

	}

	// actualizar plan

	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Tarifas actualizarTarifas(@PathVariable(name = "id") Long id, @RequestBody Tarifas tarifa) {

		Optional<Tarifas> nTarifa = repositorio.findById(id);

		if (nTarifa.isPresent()) {
			Tarifas planActual = nTarifa.get();
			planActual.setId(tarifa.getId());
			planActual.setNombreTarifa(tarifa.getNombreTarifa());
			planActual.setDescripcion(tarifa.getDescripcion());
			planActual.setMonto(tarifa.getMonto());
			planActual.setFechaCreacion(tarifa.getFechaCreacion());

			Tarifas planModificado = repositorio.save(planActual);

			return planModificado;
		}
		return null;

	}

}
