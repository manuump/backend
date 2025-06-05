package com.ociojaen.backend.services;

import com.ociojaen.backend.models.Evento;
import com.ociojaen.backend.models.Participacion;
import com.ociojaen.backend.models.Usuario;
import com.ociojaen.backend.repos.EventoRepository;
import com.ociojaen.backend.repos.ParticipacionRepository;
import com.ociojaen.backend.repos.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipacionService {

    private final ParticipacionRepository participacionRepo;
    private final UsuarioRepository usuarioRepo;
    private final EventoRepository eventoRepo;

    public Participacion participarEnEvento(Long eventoId, String username) {
        Usuario usuario = usuarioRepo.findByUsername(username).orElseThrow();
        Evento evento = eventoRepo.findById(eventoId).orElseThrow();

        if (participacionRepo.existsByUsuarioIdAndEventoId(usuario.getId(), eventoId)) {
            throw new RuntimeException("Ya estás inscrito en este evento.");
        }

        Participacion p = new Participacion();
        p.setUsuario(usuario);
        p.setEvento(evento);
        return participacionRepo.save(p);
    }

    public List<Participacion> listarParticipaciones(String username) {
        Usuario usuario = usuarioRepo.findByUsername(username).orElseThrow();
        return participacionRepo.findByUsuarioId(usuario.getId());
    }

    public void cancelarParticipacion(Long participacionId, String username) {
        Participacion p = participacionRepo.findById(participacionId).orElseThrow();
        if (!p.getUsuario().getUsername().equals(username)) {
            throw new RuntimeException("No tienes permiso para cancelar esta participación.");
        }
        participacionRepo.deleteById(participacionId);
    }

    public List<Usuario> obtenerParticipantesDeEvento(Long eventoId, String organizadorUsername) {
        
        return participacionRepo.findByEventoId(eventoId)
                .stream()
                .map(Participacion::getUsuario)
                .toList();
    }

    

}
