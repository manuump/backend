package com.ociojaen.backend.repos;

import com.ociojaen.backend.models.Participacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipacionRepository extends JpaRepository<Participacion, Long> {
    List<Participacion> findByUsuarioId(Long usuarioId);
    boolean existsByUsuarioIdAndEventoId(Long usuarioId, Long eventoId);
    List<Participacion> findByEventoId(Long eventoId);
}