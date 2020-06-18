package com.redsocial.servicio;

import java.util.List;

import com.redsocial.entidad.Factura;

public interface FacturaServicio {
	
	
	public abstract int eliminaFactura(int idFactura) ;
	public abstract int insertaFactura(Factura obj) ;
	public abstract int actualizaFactura(Factura obj) ;
	public abstract List<Factura> listaFactura(String filtro) ;
	
}
