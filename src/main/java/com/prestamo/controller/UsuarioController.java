package com.prestamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/login/{correo}/{contraseña}")
	public ResponseEntity<String> login(@PathVariable("correo") String email_usua, @PathVariable("contraseña") String con_usua) {
	    List<Usuario> usuario = usuarioService.buscarCorreoContraseña(email_usua, con_usua);
	    
	    if (usuario != null && !usuario.isEmpty()) {
	        return ResponseEntity.ok("OK");
	    }
	    
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("ERROR");
	}
	
	/*
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Usuario loginRequest) {
	    Usuario user = (Usuario) usuarioService.buscarCorreoContraseña(loginRequest.getEmail_usua(), loginRequest.getCon_usua());

	    if (user != null) {
	        return ResponseEntity.ok(user);
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
	    }
	}
*/
	
	
	
	
}
