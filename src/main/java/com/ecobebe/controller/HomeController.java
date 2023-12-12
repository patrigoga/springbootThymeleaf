package com.ecobebe.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecobebe.model.Vacante;
import com.ecobebe.service.IVacanteService;

@Controller
public class HomeController {
	
	@Autowired
	private IVacanteService serviceVacantes;
	
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		
		return"tabla";
		
		
	}
	
	
	
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de comunicaciones");
		vacante.setDescripcion("Se necesita ingeniero para dar soporte a intranet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);		
		model.addAttribute("Vacante",vacante);
		return "detalle";
		
		
	}
	
	
	
	
	@GetMapping("/listado")
	public String mostrarlistado(Model model) {
		List<String>lista = new LinkedList<String>();
		lista.add("Ingeniero de Sistemas");
		lista.add("Auxiliar de Contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos",lista);
		
		return "listado";
		
		
	}
	
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);		
		
		return "home";
	}
	
	@GetMapping("/plantilla")
	public String mostrarPlantilla(Model model) {
		
		model.addAttribute("mensaje", "Plantilla html App");
		model.addAttribute("fecha", new Date());
		return "home";
	}
	
}

