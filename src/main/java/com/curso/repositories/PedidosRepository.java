package com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.entities.Pedidos;


public interface PedidosRepository extends JpaRepository<Pedidos, Long> {

	
	
}
