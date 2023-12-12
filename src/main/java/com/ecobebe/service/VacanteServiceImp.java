package com.ecobebe.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecobebe.model.Vacante;

@Service
public class VacanteServiceImp implements IVacanteService {
	
	private List<Vacante> lista = null;
	
	public VacanteServiceImp() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();
		
		try {
			
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("solicitamos ing. civil para diseñar puetne peatonal.");
			vacante1.setFecha(sdf.parse("09-02-2023"));
			vacante1.setSalario(18500.0);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");
			
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador publico");
			vacante2.setDescripcion("Empresa importane solicita fcontador con 5 años de experiencia titulado.");
			vacante2.setFecha(sdf.parse("10-03-2023"));
			vacante2.setSalario(12000.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");
			
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Electrio");
			vacante3.setDescripcion("Empresa internacional solicita ingeniero mecánico para mantenimiento de la insalcion electrica.");
			vacante3.setFecha(sdf.parse("10-06-2023"));
			vacante3.setSalario(10500.0);
			vacante3.setDestacado(0);
			
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Ingeniero Agrario");
			vacante4.setDescripcion("Empresa internacional solicita ingeniero mecánico para mantenimiento de la insalcion electrica.");
			vacante4.setFecha(sdf.parse("10-06-2023"));
			vacante4.setSalario(10500.0);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa3.png");
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
			
			
			
		}catch(ParseException e){
			System.out.println("Error: " + e.getMessage());
			
		}
		
	}

	@Override
	public List<Vacante> buscarTodas() {
		
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		for(Vacante v : lista) {
			if (v.getId()==idVacante) {
				return v;
			}
		}
		return null;
	}

	@Override
	public void guadar(Vacante vacante) {
		lista.add(vacante);
		
	}

}
