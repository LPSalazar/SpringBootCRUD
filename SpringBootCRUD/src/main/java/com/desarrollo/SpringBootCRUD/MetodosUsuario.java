package com.desarrollo.SpringBootCRUD;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component /*marca a la clase como un bean o componente, Spring se encarga de agregarlo al contexto de la aplicacion*/
public class MetodosUsuario {

	public List<Usuario> usu;{
			
		    usu=new ArrayList<Usuario>();
			usu.add(new Usuario(1,"Luis","Salazar","Luis@correo.com"));
			usu.add(new Usuario(2,"Marcia","Anna","Mar@correo.com"));
			usu.add(new Usuario(3,"Nicolás","Bravo","Bravo@correo.com"));
			usu.add(new Usuario(4,"Diego","Miranda","hehehe@correo.com"));
	
		}
	
	public List listaDeUsuarios() {
		
			return usu;
			
	}
		
	public Usuario verUsuario(int id) {
		
		for(Usuario usuario:usu) {
			if(usuario.getId()==id) {
				return usuario;
			}
		}
		return null;
	}
	
	public Usuario crearUsuario(Usuario usuario) {
		
		usu.add(usuario);
		return usuario;
	}
	
	public int eliminarUsuario(int id) {
		
		for(Usuario usuario:usu) {
			if(usuario.getId()==id) {
				usu.remove(usuario);
				return id;
			}
		}
		return 0;
	}
	
	public Usuario editarUsuario(int id, Usuario usuario) {
		
		for(Usuario su :usu) {
			if(su.getId()==id) {
				usuario.setId(su.getId());
				usu.remove(su);
				usu.add(usuario);
				return usuario;
			}
		}
		return null;
	}
}
