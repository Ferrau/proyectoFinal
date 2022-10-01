package com.todocodeacademy.proyectoFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.todocodeacademy.proyectoFinal.model.Cliente;
import com.todocodeacademy.proyectoFinal.service.IClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private IClienteService clientServ;
	
	//CREAR
	@PostMapping("/clientes/crear")
	public String saveCliente(@RequestBody Cliente cli) {
		 clientServ.saveCliente(cli);
		 return "La creacion del nuevo cliente fue exitosa";
	}
	
	//Lista completa de clientes
	@GetMapping("/clientes")
	public List<Cliente> listaCliente (){
		
		return clientServ.listaCliente();
		
	}
	
	//Traer un cliente en particular
	@GetMapping("/clientes/{id_cliente}")
	public Cliente cli(@PathVariable Long id_cliente) {
		return clientServ.findcliente(id_cliente);
	}

	//Eliminacion de cliente
	@DeleteMapping("/clientes/eliminar/{id_cliente}")
	public String deleteCliente(@PathVariable Long id_cliente) {
		clientServ.deleteCliente(id_cliente);
		return "La eliminacion del cliente fue exitoso";
		
	}
	
	//Edicion de cliente
	@PutMapping("/clientes/editar/{id_cliente}")
	public Cliente editCliente(@PathVariable Long id_cliente,
	
			@RequestParam (required = false, name = "id_cliente") Long idNuevo,
			@RequestParam (required = false, name = "nombre") String nombreNuevo,
			@RequestParam (required = false, name = "apellido") String apellidoNuevo,
			@RequestParam (required = false, name = "dni") String dniNuevo) {
		
	
			//vamos al metodo de editar 
			clientServ.editCliente(id_cliente, idNuevo, nombreNuevo, apellidoNuevo, dniNuevo);
			//Buscamos por id
		   Cliente cliente=  clientServ.findcliente(idNuevo);
			
			 //devolvemos el nuevo objeto
			return cliente ;
		
	
	}
	
	
	//Edicion de cliente con id
	@PutMapping("/clientes/editar") //Se modifica el endpoint de editar
	public Cliente editCliente(@RequestBody Cliente cli) {
		//vamos al metodo de editar 
		clientServ.editCliente(cli);
		
		//buscamos por codigo de producto y lo devolvemos
		return clientServ.findcliente(cli.getId_cliente());
		
	}
	
	
	
//	@PutMapping("/clientes/editar/{id}")
//	public ResponseEntity<Cliente> editCliente(@RequestBody Cliente cli, @PathVariable Long id_cliente){
//			
//			try {
//				
//				Cliente cliexis= clientServ.findcliente(id_cliente);
//				
//				/*Actualizamos el producto en nuestra base de datos*/
//				cliexis.setNombre(producto.getNombre());
//				cliexis.setPrecio(producto.getPrecio());
//				
//				servicio.guardarProductos(productoExistente);	
//				return new ResponseEntity<Producto>(HttpStatus.OK);
//				
//				/*ResponseEntity: clase que que tiene un cuerpo(objeto), estado(OK/NOT_FOUNF) */
//				
//			}catch (Exception excepcion){
//				/*Si sucede algu error, le saldra en pantalla al usuario que no se ha encontrado el dato buscado*/
//				return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
//			}
//		
//		}
//	
	
}
