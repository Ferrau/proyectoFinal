package com.todocodeacademy.proyectoFinal.service;

import java.time.LocalDate;
import java.util.List;

import com.todocodeacademy.proyectoFinal.dto.VentaFechaDTO;
import com.todocodeacademy.proyectoFinal.dto.VentaMayorDTO;
import com.todocodeacademy.proyectoFinal.model.Cliente;
import com.todocodeacademy.proyectoFinal.model.Producto;
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
	
	
	//Editar con el id
	public void editVenta(Long codigo_venta, Long codVentNuevo, LocalDate fechaVentNuevo, Double totalVentNuevo,List<Producto> listProdNuevo, Cliente unCliNuevo);
	
	
	//5.Obtener la lista de productos de una determinada venta
	public List<Producto> obtProductVent(Long codigo_venta);
	
	
	
	//6. Obtener la sumatoria del monto y también cantidad total de ventas 
	//de un determinado día
	public Double montoFechaDTO(LocalDate fecha_venta);
	
	public int totalVentFechaDTO(LocalDate fecha_venta);
	
	public VentaFechaDTO ventFechaDTO (LocalDate fecha_venta);
	
	
	//7. Obtener el codigo_venta, el total, la cantidad de productos, 
	//el nombre del cliente y el apellido del cliente de la venta 
	//con el monto más alto de todas.
	
	public VentaMayorDTO ventaMayorDTO();
	
}
