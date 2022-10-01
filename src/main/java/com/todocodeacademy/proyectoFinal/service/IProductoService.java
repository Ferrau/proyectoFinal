package com.todocodeacademy.proyectoFinal.service;

import java.util.List;

import com.todocodeacademy.proyectoFinal.model.Producto;

public interface IProductoService {
	
	//Metodos abstractos
	
	//alta - Creación
	public void saveProducto(Producto product);
	
	//Lista completa de productos
	public List<Producto> listaProducto();
	
	//Traer un producto en particular
	public Producto findProducto(Long codigo_producto);
	
	//Eliminacion
	public void deleteProducto(Long codigo_producto);
	
	//Modificacion- Editar
	public void editProducto(Producto produc);

	//Editar con el id
	public void editProducto(Long codigo_producto, Long idNuevo, String nombreNuevo, String marcaNuevo, Double costoNuevo,
			Double cantDispNuevo);
	
	//Obtener todos los productos cuya cantidad_disponible sea menor a 5
	public List<Producto> cantDispon();



	
	
}
