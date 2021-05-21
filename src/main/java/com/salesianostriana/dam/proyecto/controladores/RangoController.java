package com.salesianostriana.dam.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyecto.modelo.Rango;
import com.salesianostriana.dam.proyecto.servicios.RangoServicio;
import com.salesianostriana.dam.proyecto.servicios.UserServicio;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class RangoController {
	@Autowired
	private final UserServicio UserServicio;
	@Autowired
	private final RangoServicio RangoServicio;
	
	
	@GetMapping("/rangos")
	public String todosLosrangos(Model model) {
		model.addAttribute("listadoRango", RangoServicio.findAll());
		model.addAttribute("listadoUser", UserServicio.findAll());

		return "rangos";
	}
	
	
	
	
	/**
	 * Método que atiende la petición de mostrar formulario, en este caso vacío. Pasamos al model un nuevo user vacío.
	 */
	@GetMapping("/formrango")
	public String showFormr(Model model) {
		Rango Rango = new Rango();
		model.addAttribute("RangoForm",Rango);
		model.addAttribute("listadoRango", RangoServicio.findAll());

		return "formRango";
	}
	
	/**
	 * metodo que nos agregara rangos para poder luego añadirle un nuevo rango a un usuario
	 * @param Rango
	 * @param model
	 * @return
	 */
	
	@PostMapping("/addRango")
	public String submit(@ModelAttribute("RangoForm") Rango Rango, Model model) {

		RangoServicio.save(Rango);

		return "redirect:/rangos";
	}
	/**
	 * metodo que borrara un rango por completo , nota: si hay Usuarios dentro del rango no se puede borrar este
	 * @param id
	 * @return
	 */
	@GetMapping("/borrarR/{id}") public String borrarR(@PathVariable("id") long id) {
		
		   RangoServicio.deleteById(id); 
		   
		  return "redirect:/rangos";
		  }

}
