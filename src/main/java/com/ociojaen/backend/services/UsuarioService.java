package com.ociojaen.backend.services;

import com.ociojaen.backend.models.Usuario;
import com.ociojaen.backend.repos.UsuarioRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .authorities(new ArrayList<>()) // Aquí podrías poner roles si quieres
                .build();
    }

    public Usuario save(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setEnabled(true);
        return usuarioRepository.save(usuario);
    }
}
