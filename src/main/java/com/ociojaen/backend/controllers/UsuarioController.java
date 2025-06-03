package com.ociojaen.backend.controllers;

import com.ociojaen.backend.models.Rol;
import com.ociojaen.backend.models.Usuario;
import com.ociojaen.backend.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Usuario> listarUsuarios() {
        return usuarioService.obtenerTodosUsuarios();
    }

    @PutMapping("/{id}/rol")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> cambiarRol(@PathVariable Long id, @RequestBody Rol nuevoRol) {
        usuarioService.cambiarRol(id, nuevoRol);
        return ResponseEntity.noContent().build();
    }
}
