package com.prestamo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.prestamo.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	public abstract Usuario findByUsername(String username);
	public abstract Usuario findByDni(String dni);
	public abstract Usuario findByEmail(String email);
}
