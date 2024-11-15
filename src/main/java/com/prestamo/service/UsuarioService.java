package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.Usuario;

public interface UsuarioService {
	public abstract List<Usuario> listaTodos();
	
	 public abstract Usuario buscarPorUsername(String username);
	 public abstract Usuario buscarPorDni(String dni);
	 public abstract Usuario buscarPorEmail(String email);
	 public abstract Usuario registrarUsuario(Usuario usuario);

}
