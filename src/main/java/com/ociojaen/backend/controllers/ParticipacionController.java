package com.ociojaen.backend.controllers;

import com.ociojaen.backend.models.Participacion;
import com.ociojaen.backend.services.ParticipacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participaciones")
@CrossOrigin(origins = "*")
public class ParticipacionController {

    @Autowired
    private ParticipacionService participacionService;

    @GetMapping
    public List<Participacion> getAll() {
        return participacionService.findAll();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Participacion> getByUsuario(@PathVariable Long usuarioId) {
        return participacionService.findByUsuario(usuarioId);
    }

    @GetMapping("/evento/{eventoId}")
    public List<Participacion> getByEvento(@PathVariable Long eventoId) {
        return participacionService.findByEvento(eventoId);
    }

    @PostMapping
    public Participacion create(@RequestBody Participacion participacion) {
        if (!participacionService.isAlreadyParticipating(participacion.getUsuario().getId(), participacion.getEvento().getId())) {
            return participacionService.save(participacion);
        } else {
            throw new RuntimeException("Ya estás participando en este evento.");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        participacionService.delete(id);
    }
}