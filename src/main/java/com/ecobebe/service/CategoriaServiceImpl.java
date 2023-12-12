package com.ecobebe.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecobebe.model.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriasService{
	
	private List<Categoria> lista = new LinkedList<Categoria>();
	
	public CategoriaServiceImpl() {
		Categoria categoria1 = new Categoria();
		categoria1.setId(1);
		categoria1.setNombre("Ventas");
		categoria1.setDescripcion("Descripcion categoria ventas");
		
		Categoria categoria2 = new Categoria();
		categoria2.setId(2);
		categoria2.setNombre("Contabilidad");
		categoria2.setDescripcion("Descripcion categoria contabilidad");
		
		lista.add(categoria1);
		lista.add(categoria2);
	}

	

	@Override
	@PostMapping("/save")
	public void guardar(Categoria categoria ) {
		lista.add(categoria);
		
	}

	@Override
	public List<Categoria> buscartodas() {
		
		return lista;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for(Categoria c : lista) {
			if(c.getId() == idCategoria) {
				return c;
			}
			
		}
		return null;
	}

}
