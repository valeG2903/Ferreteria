package com.redsocial.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.redsocial.entidad.Factura;
import com.redsocial.servicio.FacturaServicio;

@Controller
public class FacturaController {

	@Autowired
	private FacturaServicio servicio;
	
	@RequestMapping("/verFactura")
	public String verPagina(Model m) {
		List<Factura> list = servicio.listaFactura("");
		m.addAttribute("facturas", list);
		return "crudFactura";
	}
	
	@RequestMapping("/listaFactura")
	public String lista(@RequestParam Map<String,String> params, Model m) {
		List<Factura> list = servicio.listaFactura(params.get("filtro"));
		m.addAttribute("facturas", list);
		return "crudFactura";
	}
	
	@RequestMapping("/registraFactura")
	public String RegistraFactura(Factura obj, Model m) {
		servicio.insertaFactura(obj);
		List<Factura> list = servicio.listaFactura("");
		m.addAttribute("facturas", list);
		return "crudFactura";
	}
	
	@RequestMapping("/actualizaFactura")
	public String ActualizaFactura(Factura obj, Model m) {
		servicio.actualizaFactura(obj);
		List<Factura> list = servicio.listaFactura("");
		m.addAttribute("facturas", list);
		return "crudFactura";
	}
	
	@RequestMapping("/eliminaFactura")
	public String elimina(@RequestParam Map<String,String> params, Model m) {
		String id = params.get("id");
		servicio.eliminaFactura(Integer.parseInt(id));
		List<Factura> list = servicio.listaFactura("");
		m.addAttribute("facturas", list);
		return "crudFactura";
	}

}
