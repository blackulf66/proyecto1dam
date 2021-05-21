package com.salesianostriana.dam.proyecto.servicios;

import org.springframework.stereotype.Service;
import com.salesianostriana.dam.proyecto.modelo.User;
import com.salesianostriana.dam.proyecto.repos.UserRepository;
/**
 * servicio que extiende a servicio base
 * @author BlackUlf
 *
 */
@Service
public class UserServicio 
	extends BaseService<User, Long, UserRepository>{
}