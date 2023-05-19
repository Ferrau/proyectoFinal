package com.todocodeacademy.proyectoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="jugador")
public class Jugador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id_jugador;
	@Column (name="nombre")
	private String nombre;
	@Column (name="apellido")
	private String apellido;
	@Column (name="edad")
	private String edad;
	@Column (name="posicion")
	private String posicion;
	
	

	
	
	/*********** INICIO: CONSTRUCTOR ************ */
	public Jugador(Long id_jugador, String nombre, String apellido, String edad, String posicion) {
		super();
		this.id_jugador = id_jugador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.posicion = posicion;
	}


	public Jugador() {
		super();
	}


	

	/*********** FIN: CONSTRUCTOR ************ */
	
	/* ********* INICIO: GETTERS AND SETTERS *************/
	
	public Long getId_jugador() {
		return id_jugador;
	}


	public void setId_jugador(Long id_jugador) {
		this.id_jugador = id_jugador;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEdad() {
		return edad;
	}


	public void setEdad(String edad) {
		this.edad = edad;
	}


	public String getPosicion() {
		return posicion;
	}


	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	
	/* ********* FIN: GETTERS AND SETTERS *************/
}
