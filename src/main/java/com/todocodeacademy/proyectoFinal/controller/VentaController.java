package com.todocodeacademy.proyectoFinal.controller;

import java.time.LocalDate;
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

import com.todocodeacademy.proyectoFinal.dto.VentaFechaDTO;
import com.todocodeacademy.proyectoFinal.dto.VentaMayorDTO;
import com.todocodeacademy.proyectoFinal.model.Cliente;
import com.todocodeacademy.proyectoFinal.model.Producto;
import com.todocodeacademy.proyectoFinal.model.Venta;
import com.todocodeacademy.proyectoFinal.service.IVentaService;

@RestController
public class VentaController {
	
	@Autowired
	IVentaService ventServ;
	
	//CREAR
	@PostMapping("/ventas/crear")
	public String saveVenta(@RequestBody Venta venta) {
		ventServ.saveVenta(venta);
		return "La venta fue dada de alta correctamente";
	}
	//Lista completa de ventas
	@GetMapping("/ventas")
	public List<Venta> vent() {
		return ventServ.listaVenta();
		
	}
	
	
	//Traer una venta en particular
	@GetMapping("/ventas/{codigo_venta}")
	public Venta cli(@PathVariable Long codigo_venta) {
		return ventServ.findVenta(codigo_venta);
		
	}
	
	//Eliminacion de la venta
	@DeleteMapping("/ventas/eliminar/{codigo_venta}")
	//@DeleteMapping ("clientes/eliminar/{codigo_venta}") -- de esta forma yo lo haria
	public String deleteVenta(@PathVariable Long codigo_venta){
		
		ventServ.deleteventa(codigo_venta);
		return "La eliminacion de la venta fue exitosa";
		
	}
	
	//Edicion de venta
	//@PutMapping("/clientes/editar/{codigo_venta}")
	@PutMapping("/ventas/editar/{codigo_venta}") //-- de esta forma yo lo haria
	public Venta editVenta(@PathVariable Long codigo_venta,
			@RequestParam (required = false, name = "codigo_venta") Long codVentNuevo,
			@RequestParam (required = false, name = "fecha_venta") LocalDate fechaVentNuevo,
			@RequestParam (required = false, name = "total") Double totalVentNuevo,
			@RequestParam (required = false, name = "listaProductos") List<Producto> listProdNuevo,
			@RequestParam (required = false, name = "unCliente") Cliente unCliNuevo) {
		
				//vamos al metodo de editar
				ventServ.editVenta(codigo_venta, codVentNuevo, fechaVentNuevo, totalVentNuevo, listProdNuevo, unCliNuevo);
				
				 //Buscamos por id en el modelo
				Venta vent = ventServ.findVenta(codigo_venta);
				
				//devolvemos el nuevo objeto
				return vent;
		
		
			}
	


			//Edicion de cliente con id
			//@PutMapping("/clientes/editar")
			@PutMapping("/ventas/editar") //-- de esta forma yo lo haria
			public Venta editVenta(@RequestBody Venta vent) {
				
				 
				//vamos al metodo de editar
				ventServ.editVenta(vent);
				
				//buscamos por codigo de la venta y lo devolvemos con el get
				return ventServ.findVenta(vent.getCodigo_venta());
				
			}
	
	
	//5. Obtener la lista de productos de una determinada venta
	@GetMapping ("/ventas/productos/{codigo_venta}")
   public List<Producto> obtProducVenta(@PathVariable Long codigo_venta) {
		
		List<Producto> vent = ventServ.obtProductVent(codigo_venta);
		
		
		return vent;
		
		
	}
	
	
	//6. Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
	@GetMapping ("/ventas/{fecha_venta}")
	public VentaFechaDTO ventFechaDTO(LocalDate fecha_venta){
		
		VentaFechaDTO ventFechaDTO = ventServ.ventFechaDTO(fecha_venta);
		
		return ventFechaDTO;
		
	}
	
	
	//7. Obtener el codigo_venta, el total, la cantidad de productos, 	
	//el nombre del cliente y el apellido del cliente de la venta 
	//con el monto más alto de todas.
	@GetMapping ("/ventas/mayor_venta")
	public VentaMayorDTO ventaMayorDTO() {
		
		VentaMayorDTO ventaMayorDTO = ventServ.ventaMayorDTO();
		return ventaMayorDTO;
		
	}
		
	
	
	
	
	
}
