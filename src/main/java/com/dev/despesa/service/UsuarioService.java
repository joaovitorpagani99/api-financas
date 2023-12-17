package com.dev.despesa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.dev.despesa.auth.JwtTokenService;
import com.dev.despesa.model.Roles;
import com.dev.despesa.model.Usuario;
import com.dev.despesa.model.UsuarioDetails;
import com.dev.despesa.model.DTO.CriarUsuarioDTO;
import com.dev.despesa.model.DTO.LoginDTO;
import com.dev.despesa.model.DTO.RecoveryJwtTokenDto;
import com.dev.despesa.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private JwtTokenService jwtTokenService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario inserir(CriarUsuarioDTO usuario) {
		Roles role = Roles.builder().autorizacao(usuario.role()).build();
		
		Usuario novUsuario = Usuario.builder()
				.nome(usuario.nome())
				.email(usuario.email())
				.senha(passwordEncoder.encode(usuario.senha()))
				.roles(List.of(role))
				.build();
		try {
			var verificarEmail = usuarioRepository.findByEmail(novUsuario.getEmail());
			if (verificarEmail != null) {
				throw new RuntimeException("Email já cadastrado");
			}
			usuarioRepository.save(novUsuario);
		} catch (Exception e) {
			System.out.println("Email não cadastrado" + e.getMessage());
		}

		Usuario usuarioSalvo = usuarioRepository.save(novUsuario);
		System.out.println(usuarioSalvo.toString());
		return usuarioSalvo;
	}

	public Usuario buscar(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isEmpty()) {
			throw new RuntimeException("Usuário não encontrado");
		}
		return usuario.get();
	}

	public Usuario atualizar(Long id, Usuario usuario) {
		try {
			Usuario usuarioAtual = usuarioRepository.findById(id).get();
			usuarioAtual = usuarioRepository.save(usuarioAtual);
			return usuarioAtual;
		} catch (EntityNotFoundException e) {
			throw new RuntimeException("Id não encontrado " + id);
		}
	}

	public void deletar(Long id) {
		try {
			usuarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RuntimeException("Id não encontrado " + id);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Integridade violada");
		}
	}

	public RecoveryJwtTokenDto autenticadorUsuario(LoginDTO loginDTO) {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				loginDTO.email(), loginDTO.senha());
		System.out.println(authenticationToken.toString());

		Authentication authentication = authenticationManager
				.authenticate(authenticationToken);

		UsuarioDetails userDetails = (UsuarioDetails) authentication.getPrincipal();
		return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
	}

}
