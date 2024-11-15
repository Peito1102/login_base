package com.prestamo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ad_usua")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_usua")
	private int codigoUsuario;
	@Column(name = "no_usua")
	private String nombre;
	@Column(name = "ape_usua")
	private String apellido;
	
	@Column(name = "dni_usua",unique = true)
	private String dni;
	@Column(name = "email_usua",unique = true)
	private String email ;
	@Column(unique = true)
	private String username;
	@Column(name = "con_usua",unique = true)
	private String contrasena;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "co_tipusua")
	private TipoUsuario tipoUsuario;
	
	@Column(name = "st_autenticacion")
	private Boolean autenticacion;
	@Column(name = "st_registro")
	private Boolean estado;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "co_usua_crea")
	private Usuario usuarioCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "fe_usua_crea")
	private Date fechaCreacion;
	
}
