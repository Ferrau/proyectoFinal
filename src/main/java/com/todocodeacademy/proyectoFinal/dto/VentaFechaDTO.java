package com.todocodeacademy.proyectoFinal.dto;



public class VentaFechaDTO {
	
	
	private Double montFecha;
	private int totalVentFecha;
	
	
	public Double getMontFecha() {
		return montFecha;
	}
	public void setMontFecha(Double montFecha) {
		this.montFecha = montFecha;
	}
	public int getTotalVentFecha() {
		return totalVentFecha;
	}
	public void setTotalVentFecha(int totalVentFecha) {
		this.totalVentFecha = totalVentFecha;
	}
	
	
	public VentaFechaDTO(Double montFecha, int totalVentFecha) {
		super();
		this.montFecha = montFecha;
		this.totalVentFecha = totalVentFecha;
	}
	public VentaFechaDTO() {
		super();
	}
	
	
	
	
	
	
}
