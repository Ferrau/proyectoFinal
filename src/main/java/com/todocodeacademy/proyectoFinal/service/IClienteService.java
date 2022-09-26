package com.todocodeacademy.proyectoFinal.service;

import java.util.List;

import com.todocodeacademy.proyectoFinal.model.Cliente;

public interface IClienteService {
	
	//Metodos abstractos
	
	//alta-Creacion
	public void saveCliente(Cliente client);
	
	//lista completa de clientes
	public List<Cliente> listaCliente();
	
	//Traer un cliente en particular
	public Cliente findcliente(Long id_cliente);
	
	//Baja -Eliminacion 
	public void deleteCliente(Long id_cliente);
	
	//Modificacion -Edicion
	public void editCliente(Cliente client);
	
	//Modificacion -Edicion con id
	public void editCliente(Long id_cliente, Long idNuevo, String nombreNuevo, String apellidoNuevo, String dniNuevo);
	
	
	
}
