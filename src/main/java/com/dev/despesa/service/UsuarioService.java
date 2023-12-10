package com.dev.despesa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.dev.despesa.model.Usuario;
import com.dev.despesa.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario inserir(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario = usuarioRepository.save(usuario);
        return usuario;
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

}
