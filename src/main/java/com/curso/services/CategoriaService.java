package com.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.entities.Categorias;
import com.curso.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categorias> findAll() {
		return repository.findAll();
	}


	public Categorias findById(Long id) {

		Optional<Categorias> obj = repository.findById(id);
	
		return obj.get();
	}
}

