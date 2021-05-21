package com.salesianostriana.dam.proyecto.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * servicio base para los servicios de rango y user
 * @author BlackUlf
 *
 * @param <T>
 * @param <ID>
 * @param <R>
 */
public abstract class BaseService<T, ID, R extends JpaRepository<T,ID>> {
	
	@Autowired
	protected R repository;

	public T save(T t) {
		return repository.save(t);
	}
	
	public T edit(T t) {
		return save(t);
	}
	
	public void delete(T t) {
		repository.delete(t);
	}
	
	public void deleteById(ID id) {
		repository.deleteById(id);
	}
	
	public  List<T> findAll() {
		return repository.findAll();
	}
	
	public Optional<T> findById(ID id) {
		return repository.findById(id);
	}

}
