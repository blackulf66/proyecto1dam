package com.salesianostriana.dam.proyecto;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyecto.modelo.Rango;
import com.salesianostriana.dam.proyecto.modelo.User;
import com.salesianostriana.dam.proyecto.servicios.RangoServicio;
import com.salesianostriana.dam.proyecto.servicios.UserServicio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	@Autowired
	private final RangoServicio rangoServicio;
	@Autowired
	private final UserServicio userServicio;
	/**
	 * en esta clase tengo solo los datos de los rangos y un usuario de prueba
	 * 
	 */
	@PostConstruct
	public void initData()  {
		
		Rango r1 = new Rango("básico", "es basico , no te da nada :(");
		
		Rango r2 = new Rango("VIP", "es mejor que el rango basico, te da ventajas sobre los demas jugadores dandote un kit pvp cada vez que mueras");
		
		Rango r3 = new Rango("HUEEEEEVOOOOO", "ta bien , lanzas huevos");
		
		Rango r4 = new Rango("Fiera", "con este rango te regalaremos 1000 divisas y una parcela, ademas de contener todo lo anterior");
		
		Rango r5 = new Rango("Dragon", "tienes todo lo anterior de los demas rangos mas ademas de kit pvp diamante y unas elitros de regalo");
		
	
		User u1= new User("admin", " admin", "god", "god@gmail.com", LocalDate.now());
		userServicio.save(u1);
		User u5= new User("Börje", " Högberg", "sweedishkickass69", "sweedishkickass69@gmail.com", LocalDate.now());
		userServicio.save(u5);
		User u2= new User("humano", " normal", "nomalyo", "normal@gmail.com", LocalDate.now());
		userServicio.save(u2);
		User u3= new User("Sven", "Svenson", "killercreeper", "killercreeper55@gmail.com", LocalDate.now());
		userServicio.save(u3);
		User u4= new User("loki", "laufeyson", "god_ofMischief", "lokiGOD@gmail.com", LocalDate.now());
		userServicio.save(u4);

		rangoServicio.save(r1);
		rangoServicio.save(r2);
		rangoServicio.save(r3);
		rangoServicio.save(r4);
		rangoServicio.save(r5);
		
		
		r5.addUser(u1);
		r1.addUser(u2);
		r1.addUser(u3);
		r1.addUser(u4);
		r1.addUser(u5);
		userServicio.edit(u1);
		userServicio.edit(u2);
		userServicio.edit(u3);
		userServicio.edit(u4);
		userServicio.edit(u5);
		
		
		
		
	}

}
