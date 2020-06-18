package com.redsocial.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocial.entidad.Factura;
import com.redsocial.repositorio.FacturaRepositorio;

@Service
public class FacturaServicioImpl implements FacturaServicio{
	
	@Autowired
	private FacturaRepositorio repositorio;

	@Override
	public int eliminaFactura(int idFactura) {
		return repositorio.elimina(idFactura);
	}

	@Override
	public int insertaFactura(Factura obj) {
		return repositorio.inserta(obj);
	}

	@Override
	public int actualizaFactura(Factura obj) {
		return repositorio.actualiza(obj);
	}

	@Override
	public List<Factura> listaFactura(String filtro) {
		return repositorio.lista(filtro);
	}
	

}
