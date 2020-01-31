package com.curso.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.curso.entities.Usuarios;
import com.curso.exceptions.DatabaseException;
import com.curso.exceptions.ResourceNotFoundException;
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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Usuarios insert(Usuarios obj) {
		return repository.save(obj);
	}

	public void deletarUsuario(Long id) {

		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Usuarios update(Long id, Usuarios usuario) {
		if(repository.existsById(id)) {
			usuario.setId(id);
			repository.save(usuario);
			return usuario;
		} else {
			throw new ResourceNotFoundException(id);
		}

	}


}
