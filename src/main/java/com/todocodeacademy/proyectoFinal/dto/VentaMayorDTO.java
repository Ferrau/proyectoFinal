package com.todocodeacademy.proyectoFinal.dto;

public class VentaMayorDTO {
	
	private Long codigo_venta;
	private Double total_venta;
	private int cant_producto;
	private String nombre_cliente;
	private String apellido_cliente;
	
	
	public Long getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public Double getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}
	public int getCant_producto() {
		return cant_producto;
	}
	public void setCant_producto(int cant_producto) {
		this.cant_producto = cant_producto;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public String getApellido_cliente() {
		return apellido_cliente;
	}
	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}
	
	public VentaMayorDTO(Long codigo_venta, Double total_venta, int cant_producto, String nombre_cliente,
			String apellido_cliente) {
		super();
		this.codigo_venta = codigo_venta;
		this.total_venta = total_venta;
		this.cant_producto = cant_producto;
		this.nombre_cliente = nombre_cliente;
		this.apellido_cliente = apellido_cliente;
	}
	public VentaMayorDTO() {
		super();
	}
	
	
	
}
