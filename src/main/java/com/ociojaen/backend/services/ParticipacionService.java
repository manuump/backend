package com.ociojaen.backend.services;

import com.ociojaen.backend.models.Participacion;
import com.ociojaen.backend.repos.ParticipacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipacionService {

    @Autowired
    private ParticipacionRepository participacionRepository;

    public List<Participacion> findAll() {
        return participacionRepository.findAll();
    }

    public Optional<Participacion> findById(Long id) {
        return participacionRepository.findById(id);
    }

    public Participacion save(Participacion participacion) {
        return participacionRepository.save(participacion);
    }

    public void delete(Long id) {
        participacionRepository.deleteById(id);
    }

    public boolean isAlreadyParticipating(Long usuarioId, Long eventoId) {
        return participacionRepository.existsByUsuarioIdAndEventoId(usuarioId, eventoId);
    }

    public List<Participacion> findByUsuario(Long usuarioId) {
        return participacionRepository.findByUsuarioId(usuarioId);
    }

    public List<Participacion> findByEvento(Long eventoId) {
        return participacionRepository.findByEventoId(eventoId);
    }
}
