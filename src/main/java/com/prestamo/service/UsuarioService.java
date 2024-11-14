package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.Usuario;

public interface UsuarioService {
	public abstract List<Usuario> listaTodos();
	public List<Usuario> buscarCorreoContraseña(String email_usua, String con_usua);
}
