package com.redsocial.repositorio;

import java.util.List;

import com.redsocial.entidad.Factura;

public interface FacturaRepositorio {

	public abstract int elimina(int idCliente) ;
	public abstract int inserta(Factura obj) ;
	public abstract int actualiza(Factura obj) ;
	public abstract List<Factura> lista(String filtro);
	
}