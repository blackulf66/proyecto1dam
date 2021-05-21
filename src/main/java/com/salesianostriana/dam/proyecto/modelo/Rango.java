package com.salesianostriana.dam.proyecto.modelo;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * Clase que modela los datos de un Rango
 * 
 * @author blackulf
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Rango {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombreRango;
	
	private String Descripcion;
	/**
	 * one to many de rango a usuario ya que un rango puede albergar varios usuarios
	 * dentro de si
	 */
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "rango", fetch = FetchType.EAGER) 
	private List<User> User = new ArrayList<>();
	/**
	 * 
	 * @param nombreRango
	 * @param descripcion
	 * @param User
	 */
	public Rango(String nombreRango, String descripcion, List<User> User) {
		super();
		this.nombreRango = nombreRango;
		Descripcion = descripcion;
		this.User = User;
	}
	/**
	 * 
	 * @param nombreRango
	 * @param descripcion
	 */
	public Rango(String nombreRango, String descripcion) {
		super();
		this.nombreRango = nombreRango;
		Descripcion = descripcion;
	}

	/**
	 * metodos helper para agregar
	 * @param U
	 */
	public void addUser(User U) {
		this.User.add(U);
		U.setRango(this);
	}
	/**
	 * metodos helper para borrar
	 * @param U
	 */
	public void removeUser(User U) {
		this.User.remove(U);
		U.setRango(null);
	}


}
