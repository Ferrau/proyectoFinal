package com.todocodeacademy.proyectoFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.proyectoFinal.model.Producto;
import com.todocodeacademy.proyectoFinal.repository.IProductoRepository;

@Service
public class ProductoService implements IProductoService{

	@Autowired
	private IProductoRepository productRepo;
	
	@Override
	public void saveProducto(Producto product) {
		
		productRepo.save(product);
	}

	@Override
	public List<Producto> listaProducto() {
		List<Producto> listproduct = productRepo.findAll();
		return listproduct;
	}

	@Override
	public Producto findProducto(Long codigo_producto) {
		Producto findProduct = productRepo.findById(codigo_producto).orElse(null);
		return findProduct;
	}

	@Override
	public void deleteProducto(Long codigo_producto) {
		productRepo.deleteById(codigo_producto);
		
	}

	@Override
	public void editProducto(Producto produc) {
		this.saveProducto(produc);
		
	}


	@Override
	public void editProducto(Long codigo_producto, Long idNuevo, String nombreNuevo, String marcaNuevo, Double costoNuevo,
			Double cantDispNuevo) {
		
		
			// Busco el objeto original 
				Producto product = this.findProducto(codigo_producto);
				
				//proceso de modificacion a nivel logico
				product.setCodigo_producto(idNuevo);
				product.setNombre(nombreNuevo);
				product.setMarca(marcaNuevo);
				product.setCosto(costoNuevo);
				product.setCantidad_disponible(cantDispNuevo);
				
				//llama al repositorio para guardar los nuevo cambios en la base de datos
				this.saveProducto(product);
				
		
	}

}
