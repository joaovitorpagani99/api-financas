package com.dev.despesa.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dev.despesa.model.Usuario;
import com.dev.despesa.model.UsuarioDetails;
import com.dev.despesa.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Usuario usuario = usuarioRepository.findByEmail(username)
    				.orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return new UsuarioDetails(usuario);
    }

}
