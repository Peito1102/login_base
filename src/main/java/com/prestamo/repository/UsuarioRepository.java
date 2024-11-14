package com.prestamo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
    @Query("SELECT u FROM Usuario u WHERE u.email_usua = :email_usua AND u.con_usua = :con_usua")
	public List<Usuario> buscarCorreoContraseña(String email_usua, String con_usua);

}
