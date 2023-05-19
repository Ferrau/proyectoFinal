package com.todocodeacademy.proyectoFinal.service;

import java.util.List;

import com.todocodeacademy.proyectoFinal.model.Jugador;

public interface IJugadorService {
	
	//Metodos abstractos
	
	//alta-Creacion
	public void saveJugador(Jugador jugador);
	
	//lista completa de clientes
	public List<Jugador> listaJugador();
	
	//Traer un cliente en particular
	public Jugador findJugador(Long id_jugador);
	
	//Baja -Eliminacion 
	public void deleteJugador(Long id_jugador);
	
	//Modificacion -Edicion
	public void editJugador(Jugador jugador);
	
	//Modificacion -Edicion con id
	public void editJugador(Long id_jugador, Long idNuevo, String nombreNuevo, String apellidoNuevo, String edadNuevo, String posicionNuevo);
	
	
	
}
