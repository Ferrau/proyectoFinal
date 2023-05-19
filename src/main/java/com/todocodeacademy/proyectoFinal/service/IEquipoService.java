package com.todocodeacademy.proyectoFinal.service;

import java.util.List;

import com.todocodeacademy.proyectoFinal.model.Cliente;
import com.todocodeacademy.proyectoFinal.model.Equipo;
import com.todocodeacademy.proyectoFinal.model.Jugador;

public interface IEquipoService {
	
	//Metodos abstractos
	
	//alta-Creacion
	public void saveEquipo(Equipo equipo);
	
	//lista completa de clientes
	public List<Equipo> listaEquipo();
	
	//Traer un cliente en particular
	public Equipo findEquipo(Long id_club);
	
	//Baja -Eliminacion 
	public void deleteEquipo(Long id_club);
	
	//Modificacion -Edicion
	public void editEquipo(Equipo equipo);
	
	//Modificacion -Edicion con id
	public void editEquipo(Long id_club, Long idNuevo, String nombreNuevo, String directorNuevo, String paisNuevo, String categoriaNuevo, List<Jugador> listaNuevo);
	
	
	
}
