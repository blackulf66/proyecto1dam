package com.salesianostriana.dam.proyecto.servicios;

import java.util.List;

public interface IBaseService<T,ID>{
	
	public T save(T t) ;
	
	
	public T edit(T t) ;
	
	
	public void delete(T t) ;
	
	
	public void deleteById(ID id) ;
	
	
	public  List<T> findAll() ;
	
	
	public T findById(ID id) ;
	

}
