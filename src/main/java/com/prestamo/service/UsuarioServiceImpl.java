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
	public Usuario buscarPorUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}

	@Override
	public Usuario buscarPorDni(String dni) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByDni(dni);
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario registrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
