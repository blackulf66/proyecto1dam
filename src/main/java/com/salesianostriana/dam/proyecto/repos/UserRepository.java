package com.salesianostriana.dam.proyecto.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.proyecto.modelo.User;
/**
 * repositorio que extiende a jparepository
 * @author BlackUlf
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{

}
