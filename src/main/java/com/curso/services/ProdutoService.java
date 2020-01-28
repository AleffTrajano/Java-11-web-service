package com.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.entities.Produtos;
import com.curso.repositories.ProdutosRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutosRepository repository;

	public List<Produtos> findAll() {
		return repository.findAll();
	}


	public Produtos findById(Long id) {

		Optional<Produtos> obj = repository.findById(id);
	
		return obj.get();
	}
}

