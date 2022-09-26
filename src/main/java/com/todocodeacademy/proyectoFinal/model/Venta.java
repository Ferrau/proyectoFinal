package com.todocodeacademy.proyectoFinal.model;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="venta")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo_venta;
	@Column (name="fecha_venta")
	private LocalDate fecha_venta;
	@Column (name="total")
	private Double total;
	
/* ****  INICIO RELACION 1 A N: 1 vwnta ----- N productos ******* */
	// - BASE DE DATOS: las relaciones de base de datos la FK va del lado de la N(del lado de mascotas) 
	// - NIVEL LOGICO: La lista de mascota va del lado de la clase que tiene 1
	
	@OneToMany (mappedBy = "venta")
	private List<Producto> listaProductos;
/* ****  FIN RELACION 1 A N: 1 vwnta ----- N productos ******* */
	
	
	
	/* ****  INICIO RELACION 1 A 1: 1 cliente ----- 1 venta ******* */	
	@OneToOne 
	private Cliente unCliente;
	

	
	/* ****  FIN RELACION 1 A 1: 1 cliente ----- 1 venta ******* */
	
	
	
	
	
	/*********** INICIO: CONSTRUCTOR ************ */
	
	public Venta() {
		super();
	}
	
	public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos,
			Cliente unCliente) {
		super();
		this.codigo_venta = codigo_venta;
		this.fecha_venta = fecha_venta;
		this.total = total;
		this.listaProductos = listaProductos;
		this.unCliente = unCliente;
	}
	
	/*********** FIN: CONSTRUCTOR ************ */
	
	
	
	/* ********* INICIO: GETTERS AND SETTERS *************/
	
	public Long getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

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

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Cliente getUnCliente() {
		return unCliente;
	}

	public void setUnCliente(Cliente unCliente) {
		this.unCliente = unCliente;
	}
	
	
	/* ********* FIN: GETTERS AND SETTERS *************/
	
	
	
}
