package com.farmacia.farmacia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.farmacia.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByUsuario(String usuario);

}
