package com.todocodeacademy.proyectoFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.proyectoFinal.model.Cliente;
import com.todocodeacademy.proyectoFinal.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private IClienteRepository clientRepo;
	
	@Override
	public void saveCliente(Cliente client) {
		clientRepo.save(client);
		
	}

	@Override
	public List<Cliente> listaCliente() {
		List<Cliente> listClient = clientRepo.findAll();
		return listClient;
	}

	@Override
	public Cliente findcliente(Long id_cliente) {
		Cliente buscarCliente = clientRepo.findById(id_cliente).orElse(null);
		return buscarCliente;
	}

	@Override
	public void deleteCliente(Long id_cliente) {
		clientRepo.deleteById(id_cliente);
	}

	@Override
	public void editCliente(Cliente client) {
		this.saveCliente(client);
		
	}

	@Override
	public void editCliente(Long id_cliente, Long idNuevo, String nombreNuevo, String apellidoNuevo, String dniNuevo) {
		
		// Busco el objeto original 
		Cliente cliente = this.findcliente(id_cliente);
		
		//proceso de modificacion a nivel logico
		cliente.setId_cliente(idNuevo);
		cliente.setNombre(nombreNuevo);
		cliente.setApellido(apellidoNuevo);
		cliente.setDni(dniNuevo);
		
		//llamamos al repositorio para guardar los nuevos cambios en la base de 
		this.saveCliente(cliente);
		
		
	}

}
