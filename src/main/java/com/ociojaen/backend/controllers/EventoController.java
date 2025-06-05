package com.ociojaen.backend.controllers;

import com.ociojaen.backend.models.Evento;
import com.ociojaen.backend.services.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoService eventoService;

    @PostMapping
    @PreAuthorize("hasRole('EMPRESA')")
    public ResponseEntity<Evento> crearEvento(@RequestBody Evento evento, Authentication auth) {
        return ResponseEntity.ok(eventoService.crearEvento(evento, auth.getName()));
    }

    @GetMapping
    public ResponseEntity<List<Evento>> listarEventos() {
        return ResponseEntity.ok(eventoService.listarEventos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> obtenerEvento(@PathVariable Long id) {
        return eventoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('EMPRESA')")
    public ResponseEntity<Evento> actualizarEvento(@PathVariable Long id, @RequestBody Evento evento,
            Authentication auth) {
        return ResponseEntity.ok(eventoService.actualizarEvento(id, evento, auth.getName()));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('EMPRESA')")
    public ResponseEntity<Void> eliminarEvento(@PathVariable Long id, Authentication auth) {
        eventoService.eliminarEvento(id, auth.getName());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/mis-eventos")
    @PreAuthorize("hasRole('EMPRESA')")
    public ResponseEntity<List<Evento>> listarEventosEmpresa(Authentication auth) {
        List<Evento> eventos = eventoService.listarEventosPorEmpresa(auth.getName());
        return ResponseEntity.ok(eventos);
    }

}
