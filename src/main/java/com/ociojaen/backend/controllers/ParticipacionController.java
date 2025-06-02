package com.ociojaen.backend.controllers;

import com.ociojaen.backend.models.Participacion;
import com.ociojaen.backend.services.ParticipacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participaciones")
@RequiredArgsConstructor
public class ParticipacionController {

    private final ParticipacionService participacionService;

    @PostMapping("/evento/{eventoId}")
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<Participacion> participar(@PathVariable Long eventoId, Authentication auth) {
        return ResponseEntity.ok(participacionService.participarEnEvento(eventoId, auth.getName()));
    }

    @GetMapping
    @PreAuthorize("hasRole('USUARIO')")
    public ResponseEntity<List<Participacion>> misParticipaciones(Authentication auth) {
        return ResponseEntity.ok(participacionService.listarParticipaciones(auth.getName()));
    }
}
