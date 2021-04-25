package com.example.demo.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Clientes;
import com.example.demo.repositorios.RepositorioClientes;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Mostrar lista de clientes
@RestController
@RequestMapping(value = "/clientes")
public class ControladorClientes {

	@Autowired
	RepositorioClientes repositorio;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)

	public Collection<Clientes> getlistadoClientes() {
		Iterable<Clientes> listadoClientes = repositorio.findAll();
		return (Collection<Clientes>) listadoClientes;
	}

	// Metodo buscar cliente por ID
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Clientes getClientes(@PathVariable(name = "id") Long id) {

		Optional<Clientes> cliente = repositorio.findById(id);

		Clientes result = null;
		if (cliente.isPresent()) {
			result = cliente.get();
		}
		return result;
	}

	// Metodo Crear clientes
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Clientes crearCliente(@RequestBody Clientes cliente) {
		Clientes nuevoCliente = repositorio.save(cliente);
		return nuevoCliente;

	}

//Borrar Cliente
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void borrarCliente(@PathVariable(name = "id") Long id) {

		repositorio.deleteById(id);

	}
	// Metodo Actualizar informacion clientes

	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Clientes actualizarInfoCliente(@PathVariable(name = "id") Long id, @RequestBody Clientes cliente) {
		Optional<Clientes> nCliente = repositorio.findById(id);

		if (nCliente.isPresent()) {
			Clientes infoActual = nCliente.get();
			infoActual.setId(cliente.getId());
			infoActual.setNombre(cliente.getNombre());
			infoActual.setEdad(cliente.getEdad());
			infoActual.setSexo(cliente.getSexo());
			infoActual.setPais(cliente.getPais());
			infoActual.setFecha(cliente.getFecha());
			Clientes cModificado = repositorio.save(infoActual);

			return cModificado;
		}
		return null;

	}

}
