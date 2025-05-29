package com.ociojaen.backend.repos;

import com.ociojaen.backend.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
