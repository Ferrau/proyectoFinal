package com.todocodeacademy.proyectoFinal.service;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.todocodeacademy.proyectoFinal.dto.VentaFechaDTO;
import com.todocodeacademy.proyectoFinal.dto.VentaMayorDTO;
import com.todocodeacademy.proyectoFinal.model.Cliente;
import com.todocodeacademy.proyectoFinal.model.Producto;
import com.todocodeacademy.proyectoFinal.model.Venta;
import com.todocodeacademy.proyectoFinal.repository.IVentaRepository;

@Service
public class VentaService implements IVentaService{
	
	
	@Autowired
	IVentaRepository ventRepo;
	
	@Override
	public void saveVenta(Venta venta) {
		ventRepo.save(venta);
		
	}

	@Override
	public List<Venta> listaVenta() {
		List<Venta> listVent = ventRepo.findAll();
		return listVent;
	}

	@Override
	public Venta findVenta(Long codigo_venta) {
		Venta buscarVenta = ventRepo.findById(codigo_venta).orElse(null);
		return buscarVenta;
	}

	@Override
	public void deleteventa(Long codigo_venta) {
		ventRepo.deleteById(codigo_venta);
		
	}

	@Override
	public void editVenta(Venta vent) {
		this.saveVenta(vent);
		
	}

	@Override
	public void editVenta(Long codigo_venta, Long codVentNuevo, LocalDate fechaVentNuevo, Double totalVentNuevo,
			List<Producto> listProdNuevo, Cliente unCliNuevo) {

		// Busco el objeto original 
		Venta vent = this.findVenta(codigo_venta);
				
		//proceso de modificacion a nivel logico
		vent.setCodigo_venta(codVentNuevo);
		vent.setFecha_venta(fechaVentNuevo);
		vent.setFecha_venta(fechaVentNuevo);
		vent.setTotal(totalVentNuevo);
		vent.setListaProductos(listProdNuevo);
		vent.setUnCliente(unCliNuevo);
				
		//llama al repositorio para guardar los nuevo cambios en la base de datos
		this.saveVenta(vent);
	
	}
	
	//5.Obtener la lista de productos de una determinada venta
	@Override
	public List<Producto> obtProductVent(Long codigo_venta) {
		
		
		return this.findVenta(codigo_venta).getListaProductos();
	}

	
	
	
	
	
	
	//6. Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
	@Override
	public Double montoFechaDTO(LocalDate fecha_venta) {
		
		List<Venta> listVent = this.listaVenta();
		
		int i=0;
		double sumatoria=0;
		
		while ( i< listVent.size()) {
			if (listVent.get(i).getFecha_venta().equals(fecha_venta)) {
				
				sumatoria= listVent.get(i).getTotal();
				
			} 
			i++;
		}
		
		return sumatoria;
	}

	@Override
	public int totalVentFechaDTO(LocalDate fecha_venta) {
		
		List<Venta> listVenta = this.listaVenta();
		
		int i=0;
		int contador=0;
		
		while ( i< listVenta.size()) {
			if (listVenta.get(i).getFecha_venta().equals(fecha_venta)) {
				
				contador= contador + 1;
				
				
			} 
			i++;
		}
		
		return contador;
		
	
	}
	
	@Override
	public VentaFechaDTO ventFechaDTO(LocalDate fecha_venta) {
		
		VentaFechaDTO ventFechaDTO = new VentaFechaDTO();
		
		ventFechaDTO.setMontFecha(this.montoFechaDTO(fecha_venta));
		ventFechaDTO.setTotalVentFecha(this.totalVentFechaDTO(fecha_venta));
		
		return ventFechaDTO;
	}
	
	
	//7. Obtener el codigo_venta, el total, la cantidad de productos, 	
	//el nombre del cliente y el apellido del cliente de la venta 
	//con el monto más alto de todas.
	@SuppressWarnings("null")
	@Override
	public VentaMayorDTO ventaMayorDTO() {

	
		VentaMayorDTO ventaMayorDTO=null;
		
		List<Venta> listVent= this.listaVenta();
		
		
		
		for (int i=0; i<listVent.size(); i++) {
			
			
			if( ventaMayorDTO.getTotal_venta()< listVent.get(i).getTotal() ) {
				
				ventaMayorDTO.setTotal_venta(listVent.get(i).getTotal());
				ventaMayorDTO.setApellido_cliente(listVent.get(i).getUnCliente().getApellido());
				ventaMayorDTO.setNombre_cliente(listVent.get(i).getUnCliente().getNombre());
				ventaMayorDTO.setCodigo_venta(listVent.get(i).getCodigo_venta());
				ventaMayorDTO.setCant_producto(listVent.get(i).getListaProductos().size());
			} 
			
		}
		
		
		
		
		return ventaMayorDTO;
	}

	

	
	
	
}