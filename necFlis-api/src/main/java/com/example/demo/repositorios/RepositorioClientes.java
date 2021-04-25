package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entidades.Clientes;

public interface RepositorioClientes extends CrudRepository<Clientes, Long>{

}
