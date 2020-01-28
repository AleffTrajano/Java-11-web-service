package com.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.entities.Pedidos;
import com.curso.repositories.PedidosRepository;

@Service
public class PedidosService {

	@Autowired
	private PedidosRepository repository;

	public List<Pedidos> findAll() {
		return repository.findAll();
	}


	public Pedidos findById(Long id) {

		Optional<Pedidos> obj = repository.findById(id);
	
		return obj.get();
	}
}
