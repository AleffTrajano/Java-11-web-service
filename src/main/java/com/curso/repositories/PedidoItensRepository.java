package com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.entities.PedidoItens;


public interface PedidoItensRepository extends JpaRepository<PedidoItens, Long> {

	
	
}
