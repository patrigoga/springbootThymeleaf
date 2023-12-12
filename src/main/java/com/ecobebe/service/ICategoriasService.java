package com.ecobebe.service;

import java.util.List;

import com.ecobebe.model.Categoria;

public interface ICategoriasService {
	
	public void guardar(Categoria categoria);
	public List<Categoria>buscartodas();
	public Categoria buscarPorId(Integer idCategoria);

}
