package com.salesianostriana.dam.proyecto.modelo;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class User {
	/**
	 * clase que modela a un usuario
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	
	private String Apellido;
	
	private String Nickname;
	
	private String Email;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate Fecha;
	/**
	 * many to one para user ya que un usuario solo puede tener un rango
	 */
	@ManyToOne
	private Rango rango;
	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param nickname
	 * @param email
	 * @param fecha
	 */
	public User(String nombre, String apellido, String nickname , String email , LocalDate fecha) {
		super();
		this.nombre = nombre;
		Apellido = apellido;
		Nickname = nickname;
		Email= email;
		Fecha= fecha;
	}
	
	
}