package com.salesianostriana.dam.proyecto.controladores;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.proyecto.servicios.RangoServicio;
import com.salesianostriana.dam.proyecto.servicios.UserServicio;
import com.salesianostriana.dam.proyecto.modelo.User;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final UserServicio UserServicio;
	private final RangoServicio RangoServicio;
	
	/**
	 * Método que gestiona la petición índice ya que en ambas se mostrará la lista completa de usuarios y rangos.
	 * Para ello se añaden al GetMapping los dos nombres.
	 * 
	 */
	@GetMapping("/")
	public String todosLosRangos(Model model) {
		model.addAttribute("listadoRango", RangoServicio.findAll());
		model.addAttribute("listadoUser", UserServicio.findAll());

		return "index";
	}
	/**
	 * Método que atiende la petición de mostrar formulario, en este caso vacío. Pasamos al model un nuevo user vacío.
	 */

	@GetMapping("/form")
	public String showForm(Model model) {
		User User = new User();
		model.addAttribute("UserForm", User);
		model.addAttribute("listadoRango", RangoServicio.findAll());

		return "form";
	}

	/**
	 * Método que procesa la respuesta del formulario.
	 * Nombramos "la petición" en el PostMapping con la ruta /adduser para distinguirla de la de editar que será, 
	 * como puede verse más abajo, /editar/submit
	 * Por otro lado devolvemos o redirigimos de nuevo al controller inicial para que pinte la tabla con el nuevo usuario recién agregado
	 */
	@PostMapping("/addUser")
	public String submit(@ModelAttribute("UserForm") User User, Model model) {

		UserServicio.save(User);

		return "redirect:/";
	}
	/**
	 * Método que atiende la petición de mostrar el formulario de edición de usuario, con los datos del usuario a
	 * modificar ya cargados Para ello, Este id se decta como un parámetro al estar entre llaves y cambiará dependiendo de en qué usuario
	 * hayamos pinchado para editar. 
	 * 
	 * @param id del usuario a editar
	 * @param model
	 * @return
	 */
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		Optional<User> editar = UserServicio.findById(id);
		
		if (editar != null) {
			model.addAttribute("", editar);
			return "form";
		} else {
			return "redirect:/";
		}
		
		
	}
	
	/**
	 * Método que procesa la respuesta del formulario al editar
	 */
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("User") User u) {
		UserServicio.edit(u);
		return "redirect:/";
	}
/*
	@GetMapping("/editar/{id}")
	public String Edicion(@PathVariable("id") long id, Model model) {

		User Edit = UserServicio.findById(id);
				
		if (Edit != null) {
			model.addAttribute("Usuario", Edit);
			return "form";
		} else {
			return "redirect:/";
		}
	}

	@PostMapping("/editar/submit")
	public String Edicion(@ModelAttribute("User") User u) {
		UserServicio.edit(u);
		return "redirect:/";
	}
	*/

	/**
	 * metodo que borra a un usuario dentro de un rango
	 * @param id
	 * @return
	 */
	@GetMapping("/borrar/{id}") public String borrar(@PathVariable("id") long id)
	  { UserServicio.deleteById(id); return "redirect:/"; }
	 

	

}
