package com.example.demo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagos")
public class Pagos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@Column(name = "fecha")
	private String fecha;
	@Column(name = "monto")
	private int monto;
	@Column(name = "Tarjeta")
	private int Tarjeta;
	@Column(name = "estado")
	private String estado;

	public int getTarjeta() {
		return Tarjeta;
	}

	public void setTarjeta(int tarjeta) {
		Tarjeta = tarjeta;
	}

	public Long getId() {
		return id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

}
