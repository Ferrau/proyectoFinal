package com.todocodeacademy.proyectoFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
