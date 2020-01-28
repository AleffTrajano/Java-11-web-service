package com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.entities.Produtos;


public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	
	
}
