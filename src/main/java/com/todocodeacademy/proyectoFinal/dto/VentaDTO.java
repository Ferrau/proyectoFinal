package com.todocodeacademy.proyectoFinal.dto;



import java.time.LocalDate;

public class VentaDTO {
	
	
	
	
	private LocalDate fecha_venta;
	private Double total;
	
	
	public LocalDate getFecha_venta() {
		return fecha_venta;
	}
	public void setFecha_venta(LocalDate fecha_venta) {
		this.fecha_venta = fecha_venta;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	public VentaDTO( LocalDate fecha_venta, Double total) {
		super();
		this.fecha_venta = fecha_venta;
		this.total = total;
	}
	public VentaDTO() {
		super();
	}
	
	
	
	
	
	
	
	
	
}
