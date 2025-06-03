package com.ociojaen.backend.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.ociojaen.backend.models.Rol;
import com.ociojaen.backend.models.Usuario;
import com.ociojaen.backend.repos.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void cambiarRol(Long idUsuario, Rol nuevoRol) {
        Usuario user = usuarioRepository.findById(idUsuario).orElseThrow();
        user.setTipo(nuevoRol);
        usuarioRepository.save(user);
    }

}
