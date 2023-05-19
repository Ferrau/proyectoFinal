package com.todocodeacademy.proyectoFinal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="equipo")
public class Equipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id_club;
	@Column (name="nombreClub")
	private String nombreClub;
	@Column (name="directorTecnico")
	private String directorTecnico;
	@Column (name="pais")
	private String pais;
	@Column (name="categoria")
	private String categoria;
	@Column (name="listaJugador")
	private List<Jugador> listaJugador;
	

	
	
	/*********** INICIO: CONSTRUCTOR ************ */
	
	public Equipo(Long id_club, String nombreClub, String directorTecnico, String pais, String categoria,
			List<Jugador> listaJugador) {
		super();
		this.id_club = id_club;
		this.nombreClub = nombreClub;
		this.directorTecnico = directorTecnico;
		this.pais = pais;
		this.categoria = categoria;
		this.listaJugador = listaJugador;
	}

	public Equipo() {
		super();
	}



	
	/*********** FIN: CONSTRUCTOR ************ */
	
	/* ********* INICIO: GETTERS AND SETTERS *************/
	public Long getId_club() {
		return id_club;
	}

	public void setId_club(Long id_club) {
		this.id_club = id_club;
	}

	public String getNombreClub() {
		return nombreClub;
	}

	public void setNombreClub(String nombreClub) {
		this.nombreClub = nombreClub;
	}

	public String getDirectorTecnico() {
		return directorTecnico;
	}

	public void setDirectorTecnico(String directorTecnico) {
		this.directorTecnico = directorTecnico;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Jugador> getListaJugador() {
		return listaJugador;
	}

	public void setListaJugador(List<Jugador> listaJugador) {
		this.listaJugador = listaJugador;
	}
	
	
	/* ********* FIN: GETTERS AND SETTERS *************/
}
