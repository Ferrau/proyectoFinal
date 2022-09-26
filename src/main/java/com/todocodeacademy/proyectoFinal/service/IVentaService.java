package com.todocodeacademy.proyectoFinal.service;

import java.util.List;

import com.todocodeacademy.proyectoFinal.model.Venta;

public interface IVentaService {
	
	//Metodos abstractos
	
	//Alta- creacion
	public void saveVenta(Venta venta);
	
	//Lista completa de ventas realizadas
	public List<Venta> listaVenta();
	
	//Traer una venta en particular
	public Venta findVenta(Long codigo_venta);
	
	//Baja- eliminacion
	public void deleteventa(Long codigo_venta);
	
	//Modificacion - edicion
	public void editVenta(Venta vent);
	
}
