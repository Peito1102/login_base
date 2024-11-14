package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.Usuario;
import com.prestamo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> listaTodos() {
		return usuarioRepository.findAll();
	}

	@Override
	public List<Usuario> buscarCorreoContraseña(String email_usua, String con_usua) {
	    return usuarioRepository.buscarCorreoContraseña(email_usua, con_usua);
	}
}
