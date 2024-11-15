package com.prestamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.Usuario;
import com.prestamo.service.UsuarioService;

@RestController
@RequestMapping("/url/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/lista")
	public List<Usuario> lista(){
		return usuarioService.listaTodos();
	}
	
	@GetMapping("/buscarPorUsername/{username}")
	public Usuario buscarPorUsername(@PathVariable String username){
		return usuarioService.buscarPorUsername(username);
	}
	
	@GetMapping("/buscarPorDniusua/{dni}")
	public Usuario buscarPorDni(@PathVariable String dni){
		return usuarioService.buscarPorDni(dni);
	}
	
}
