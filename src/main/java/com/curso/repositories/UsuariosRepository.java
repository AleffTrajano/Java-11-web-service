package com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.entities.Usuarios;


public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

	
	
}
