package com.prestamo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.TipoUsuario;
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
	
	@GetMapping("/buscarPorEmailusua/{email}")
	public Usuario buscarPorEmail(@PathVariable String email){
		return usuarioService.buscarPorEmail(email);
	}
	
	@PostMapping("/registraUsuario")
	public ResponseEntity<?> registra(@RequestBody Usuario objUsuario){
		HashMap<String, Object> salida = new HashMap<>();
		
		objUsuario.setFechaCreacion(new Date());
		objUsuario.setEstado(true);
		objUsuario.setAutenticacion(true);
		
		TipoUsuario tipoUsuario=new TipoUsuario();
		tipoUsuario.setCodigo(1);
		objUsuario.setTipoUsuario(tipoUsuario);
		
		Usuario objSalida = usuarioService.registrarUsuario(objUsuario);
		if (objSalida == null) {
			salida.put("mensaje", "Error en el registro");
		}
		else {
			salida.put("mensaje", "Registro de usuario con el ID: >>> " + objUsuario.getCodigoUsuario() + 
										" >>> Username: >> "+ objUsuario.getUsername());
		}
		return ResponseEntity.ok(salida);
	}
	
	
}