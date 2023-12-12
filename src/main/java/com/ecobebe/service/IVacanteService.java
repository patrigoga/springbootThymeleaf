package com.ecobebe.service;

import java.util.List;

import com.ecobebe.model.Vacante;

public interface IVacanteService {
	
	List<Vacante> buscarTodas();
	
	Vacante buscarPorId(Integer idVacante);
	
	public void guadar (Vacante vacante);

}
