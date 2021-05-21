package com.salesianostriana.dam.proyecto.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto.modelo.Rango;
import com.salesianostriana.dam.proyecto.repos.RangoRepository;
/**
 * servicio que extiende a servicio base
 * @author BlackUlf
 *
 */

@Service
public class RangoServicio 
	extends BaseService<Rango, Long, RangoRepository>{

}
