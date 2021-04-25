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

import com.example.demo.entidades.Pagos;
import com.example.demo.repositorios.repositorioPagos;

//Mostrar Lista de pagos
@RestController
@RequestMapping(value = "/pagos")
public class ControladorPagos {

	@Autowired
	repositorioPagos repositorio;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)

	public Collection<Pagos> getlistaPagos() {
		Iterable<Pagos> listaPagos = repositorio.findAll();
		return (Collection<Pagos>) listaPagos;

	}
	
	
	//Buscar pago especifico
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Pagos getPagos(@PathVariable(name = "id") Long id) {

		Optional<Pagos> pago = repositorio.findById(id);

		Pagos result = null;
		if (pago.isPresent()) {
			result = pago.get();
		}
		return result;
	}
	
	
	
	
	
	//Realizar pago
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pagos realizarPago(@RequestBody Pagos pago) {
		Pagos pagoR = repositorio.save(pago);
		return pagoR;

	}

	//Borrar pago
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	
	public void borrarPago (@PathVariable(name="id")Long id) {
		repositorio.deleteById(id);
	}
	
	
	//Actualizar pago
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Pagos actualizarPago (@PathVariable(name="id")Long id, @RequestBody Pagos pago) {
	
		Optional<Pagos> nuevoPago = repositorio.findById(id);
		
		if (nuevoPago.isPresent()) {
			Pagos pagoActual = nuevoPago.get();
			pagoActual.setId(pago.getId());
			pagoActual.setFecha(pago.getFecha());
			pagoActual.setMonto(pago.getMonto());
			pagoActual.setTarjeta(pago.getTarjeta());
			pagoActual.setEstado(pago.getEstado());
			
			Pagos pagoActualizado=repositorio.save(pagoActual);
			
			return pagoActualizado;
		}
		return null;
		
	}
}
