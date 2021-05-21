package com.salesianostriana.dam.proyecto.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<T, ID, R extends JpaRepository<T,ID>> implements IBaseService<T,ID> {
	
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
	
	public T findById(ID id) {
		return repository.findById(id).orElse(null);
	}
	

}
