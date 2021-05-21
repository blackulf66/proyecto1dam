package com.salesianostriana.dam.proyecto;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyecto.modelo.Rango;
import com.salesianostriana.dam.proyecto.modelo.User;
import com.salesianostriana.dam.proyecto.servicios.RangoServicio;
import com.salesianostriana.dam.proyecto.servicios.UserServicio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final RangoServicio rangoServicio;
	
	private final UserServicio userServicio;
	/**
	 * en esta clase tengo solo los datos dew los rangos y un usuario de prueba
	 * 
	 */
	@PostConstruct
	public void initData()  {
		
		Rango r1 = new Rango("básico", "es basico");
		
		Rango r2 = new Rango("VIP", "es mejor que el rango basico");
		
		Rango r3 = new Rango("HUEEEEEVOOOOO", "ta bien");
		
		Rango r4 = new Rango("Fiera", "es la hostia");
		
		Rango r5 = new Rango("Dragon", "vuelas en el servidor");
		
		User u1= new User("admin", " admin", "god", "god@gmail.xom", LocalDate.now());
		
		rangoServicio.save(r1);
		rangoServicio.save(r2);
		rangoServicio.save(r3);
		rangoServicio.save(r4);
		rangoServicio.save(r5);
		userServicio.save(u1);
		
	}

}
