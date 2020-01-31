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

	public Usuarios update(Long id, Usuarios obj) {
		try {
			Usuarios entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	// so vai atualizar esses
	private void updateData(Usuarios entity, Usuarios obj) {
		// TODO Auto-generated method stub
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}
}
