package com.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.entities.Usuarios;
import com.curso.repositories.UsuariosRepository;

@Service
public class UsuariosService {

	@Autowired
	private UsuariosRepository repository;

	public List<Usuarios> findAll() {
		return repository.findAll();
	}


	public Usuarios findById(Long id) {

		Optional<Usuarios> obj = repository.findById(id);
		return obj.get();
	}
}
