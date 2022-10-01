package com.todocodeacademy.proyectoFinal.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo_producto;
	@Column (name="nombre")
	private String nombre;
	@Column (name="marca")
	private String marca;
	@Column (name="costo")
	private Double costo;
	@Column (name="cantidad_disponible")
	private Double cantidad_disponible;
	
	
	/*********** INICIO: CONSTRUCTOR ************ */
	
	
	
	public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible) {
		super();
		this.codigo_producto = codigo_producto;
		this.nombre = nombre;
		this.marca = marca;
		this.costo = costo;
		this.cantidad_disponible = cantidad_disponible;
		
	}
	
	
	public Producto() {
		super();
	}


	/*********** FIN: CONSTRUCTOR ************ */
	
	
	/* ********* INICIO: GETTERS AND SETTERS *************/
	
	public Long getCodigo_producto() {
		return codigo_producto;
	}


	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public Double getCosto() {
		return costo;
	}


	public void setCosto(Double costo) {
		this.costo = costo;
	}


	public Double getCantidad_disponible() {
		return cantidad_disponible;
	}


	public void setCantidad_disponible(Double cantidad_disponible) {
		this.cantidad_disponible = cantidad_disponible;
	}

	
	
	/* ********* FIN: GETTERS AND SETTERS *************/
}
