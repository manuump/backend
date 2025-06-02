package com.ociojaen.backend.services;

import com.ociojaen.backend.models.Evento;
import com.ociojaen.backend.models.Usuario;
import com.ociojaen.backend.repos.EventoRepository;
import com.ociojaen.backend.repos.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepo;
    private final UsuarioRepository usuarioRepo;

    public Evento crearEvento(Evento evento, String username) {
        Usuario organizador = usuarioRepo.findByUsername(username).orElseThrow();
        evento.setOrganizador(organizador);
        return eventoRepo.save(evento);
    }

    public List<Evento> listarEventos() {
        return eventoRepo.findAll();
    }

    public Optional<Evento> obtenerPorId(Long id) {
        return eventoRepo.findById(id);
    }

    public Evento actualizarEvento(Long id, Evento nuevoEvento, String username) {
        Evento existente = eventoRepo.findById(id).orElseThrow();
        if (!existente.getOrganizador().getUsername().equals(username)) {
            throw new RuntimeException("No autorizado");
        }

        existente.setNombre(nuevoEvento.getNombre());
        existente.setDescripcion(nuevoEvento.getDescripcion());
        existente.setFecha(nuevoEvento.getFecha());
        existente.setUbicacion(nuevoEvento.getUbicacion());
        return eventoRepo.save(existente);
    }

    public void eliminarEvento(Long id, String username) {
        Evento evento = eventoRepo.findById(id).orElseThrow();
        if (!evento.getOrganizador().getUsername().equals(username)) {
            throw new RuntimeException("No autorizado");
        }
        eventoRepo.delete(evento);
    }
}
