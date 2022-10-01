package com.todocodeacademy.proyectoFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.proyectoFinal.model.Producto;
import com.todocodeacademy.proyectoFinal.service.IProductoService;


@RestController
public class ProductoController {
	
	@Autowired
	IProductoService productServ;
	
	//CREAR
	@PostMapping("/productos/crear")
	public String saveProducto(@RequestBody Producto product) {
		productServ.saveProducto(product);
		return "El producto fue creado correctamente";
	}
	
	//Lista completa de productos
	@GetMapping("/productos")
	public List<Producto> listaProducto(){
		return productServ.listaProducto();
		
	}
	
	//Traer un producto en particular
	@GetMapping("/productos/{codigo_producto}")
	public Producto producto(@PathVariable Long codigo_producto) {
		return productServ.findProducto(codigo_producto);
		
	}
	
	//Eliminacion
	@DeleteMapping("/productos/eliminar/{codigo_producto}")
	public String deleteProducto(@PathVariable Long codigo_producto) {
		productServ.deleteProducto(codigo_producto);
		return "El producto fue eliminado correctamente";
	
	}
	
	//Edicion
	@PutMapping("/productos/editar")
		public Producto editProducto(@RequestBody Producto product) {
			
			productServ.editProducto(product); //vamos al metodo de editar
			return productServ.findProducto(product.getCodigo_producto()); //buscamos por codigo de producto y lo devolvemos
					
	}
	
	//Edicion
	@PutMapping("/productos/editar/{codigo_producto}")
	public Producto editProducto(@PathVariable Long codigo_producto,
			@RequestParam(required = false, name = "codigo_producto") Long idNuevo,
			@RequestParam(required = false, name = "nombre") String nombreNuevo,
			@RequestParam(required = false, name = "marca") String marcaNuevo,
			@RequestParam(required = false, name = "costo") Double costoNuevo,
			@RequestParam(required = false, name = "cantidad_disponible") Double cantDispNuevo) {
		
		productServ.editProducto(codigo_producto, idNuevo, nombreNuevo, marcaNuevo,costoNuevo,cantDispNuevo );
		
		Producto product = productServ.findProducto(idNuevo);
		
		return product;
	}
	
	
	
	//4.Obtener todos los productos cuya cantidad_disponible sea menor a 5
	@GetMapping ("/productos/falta_stock")
	public List<Producto>cantDispon(){
		return productServ.cantDispon();
	}
	
	 
	
	
	//RequestBody: nos trae todos los parametros dentro del body
	//RequestParam: trae todos los parametros en la url
	//PathVariable: trae los parametros en la url
	
}
