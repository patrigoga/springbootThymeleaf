package com.ecobebe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecobebe.model.Vacante;
import com.ecobebe.service.IVacanteService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	private IVacanteService serviceVacantes;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "vacantes/listVacantes";
	}

	@GetMapping("/create")
	public String crear(Vacante vacante) {
		return "vacantes/formVacante";
	}

	@PostMapping("/save")
	public String guardar(Vacante vacantes, BindingResult result,RedirectAttributes attributes) {

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());			}

			return "vacantes/formVacante";
		}
		serviceVacantes.guadar(vacantes);
		
		attributes.addFlashAttribute("msg", "Registro Guardado correctamente");
		
		
		
		System.out.println("Vacante: " + vacantes);
		return "redirect:/vacantes/index";
	}

	/*
	 * @PostMapping("/save") public String guardar(@RequestParam("nombre") String
	 * nombre, @RequestParam("descripcion") String
	 * descripcion, @RequestParam("estatus") String estatus,
	 * 
	 * @RequestParam("fecha") String fecha, @RequestParam("destacado") int
	 * destacado, @RequestParam("salario") double salario, @RequestParam("detalles")
	 * String detalles ){
	 * 
	 * System.out.println("nombre vacante: "+ nombre);
	 * System.out.println("descripcion: "+ descripcion);
	 * System.out.println("estatus: "+ estatus);
	 * System.out.println("Fecha publicacion "+ fecha);
	 * System.out.println("Destacado: "+ destacado); System.out.println("salario: "+
	 * salario); System.out.println("detalles: "+ detalles); return
	 * "vacantes/listVacantes"; }
	 */

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("Borrado vacante con id: " + idVacante);

		model.addAttribute("id", idVacante);

		return "vacantes/mensaje";
	}

	@GetMapping("/view/{id}")
	public String verDetaller(@PathVariable("id") int idVacante, Model model) {

		Vacante vacante = serviceVacantes.buscarPorId(idVacante);

		System.out.println("Vacante: " + vacante);

		model.addAttribute("Vacante", vacante);

		// buscar los detalles de la vacante

		return "detalle";
	}

	// se usa para formatear la fecha
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
