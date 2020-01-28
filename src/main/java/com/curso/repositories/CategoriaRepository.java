package com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.entities.Categorias;


public interface CategoriaRepository extends JpaRepository<Categorias, Long> {

	
	
}
