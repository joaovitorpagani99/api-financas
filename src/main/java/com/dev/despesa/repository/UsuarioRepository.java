package com.dev.despesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.dev.despesa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	UserDetails findByEmail(String email);
}
