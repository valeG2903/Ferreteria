package com.redsocial.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocial.entidad.Proveedor;
import com.redsocial.repositorio.ProveedorRepositorio;

@Service
public class ProveedorServicioImpl implements ProveedorServicio {

	@Autowired
	private ProveedorRepositorio repositorio;

	@Override
	public int eliminaProveedor(int idProveedor) {
		return repositorio.elimina(idProveedor);
	}

	@Override
	public int insertaProveedor(Proveedor obj) {
		return repositorio.inserta(obj);
	}

	@Override
	public int actualizaProveedor(Proveedor obj) {
		return repositorio.actualiza(obj);
	}

	@Override
	public List<Proveedor> listaProveedor(String filtro) {
		return repositorio.lista(filtro);
	}



}






