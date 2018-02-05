package com.desarrollo.SpringBootCRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /*esta anotacion le indica a SpringFramework que las peticiones http seran manejadas por esta clase (Es para hacer una API REST)*/
public class UsuarioController {

	@Autowired/* sirve para inyectar un bean (utiliza la autodeteccion de Spring para identificarlo) */
	private MetodosUsuario metodo;
	
	@RequestMapping("/")/*esta anotacion indica que la peticion realizada por la URL sera manejada por el metodo especificado (en este caso verTodosLosUsuarios)*/
	public List verTodosLosUsuarios() {
		
		return metodo.listaDeUsuarios();
	}
	
	@RequestMapping("/seleccionar/{id}")
	public ResponseEntity seleccionaUsuario(@PathVariable("id")int id) {
		/*la clase ResponseEntity (de SpringFramework) representa la respuesta HTTP*/
		/*en documentacion oficial ResponseEntity: modela la respuesta HTTP y con la que podemos devolver los objetos serializados, fijar el código de estado y añadir cabeceras. */
		
		Usuario usu=metodo.verUsuario(id);
		if(usu==null) {
			return new ResponseEntity("no se encontro al usuario con el id: "+id,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(usu ,HttpStatus.OK);
	}
	
	@RequestMapping("/crear")
	public ResponseEntity crearUsuario(@RequestBody Usuario usuario) {
		/*con @RequestBody se reciben los datos desde el cliente*/
		metodo.crearUsuario(usuario);
		return new ResponseEntity (usuario,HttpStatus.OK);
		
	}
	
	@RequestMapping("/eliminar/{id}")
	public ResponseEntity eliminarUsuario(@PathVariable("id") int  id) {
		
		if(0 == metodo.eliminarUsuario(id)) {
			
			return new ResponseEntity("no se encontro el usuario: "+ id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(id, HttpStatus.OK);
	}
	
	@RequestMapping("/actualizar/{id}")
	public ResponseEntity actualizarUsuario(@PathVariable("id") int id,@RequestBody Usuario usuario) {
		
		usuario=metodo.editarUsuario(id, usuario);
		if(usuario==null) {
			return new ResponseEntity ("no se encontro usuario "+id,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(usuario,HttpStatus.OK);
	}
	
}
