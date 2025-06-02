package com.ociojaen.backend.repos;

import com.ociojaen.backend.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByOrganizadorId(Long organizadorId);
}