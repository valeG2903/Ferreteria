package com.redsocial.entidad;

public class Factura {

	private int idFactura;
	private String numero_factura;
	private String fecha_factura;
	private String total_venta;
	private String estado_factura;
	
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public String getNumero_factura() {
		return numero_factura;
	}
	public void setNumero_factura(String numero_factura) {
		this.numero_factura = numero_factura;
	}
	public String getFecha_factura() {
		return fecha_factura;
	}
	public void setFecha_factura(String fecha_factura) {
		this.fecha_factura = fecha_factura;
	}
	public String getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(String total_venta) {
		this.total_venta = total_venta;
	}
	public String getEstado_factura() {
		return estado_factura;
	}
	public void setEstado_factura(String estado_factura) {
		this.estado_factura = estado_factura;
	}
	
	
	
}
