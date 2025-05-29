package com.ociojaen.backend.controllers;

import com.ociojaen.backend.models.Evento;
import com.ociojaen.backend.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "*")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getAll() {
        return eventoService.findAll();
    }

    @GetMapping("/{id}")
    public Evento getById(@PathVariable Long id) {
        return eventoService.findById(id).orElse(null);
    }

    @PostMapping
    public Evento create(@RequestBody Evento evento) {
        return eventoService.save(evento);
    }

    @PutMapping("/{id}")
    public Evento update(@PathVariable Long id, @RequestBody Evento evento) {
        evento.setId(id);
        return eventoService.save(evento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventoService.delete(id);
    }
}
