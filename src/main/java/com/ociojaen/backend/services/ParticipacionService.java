package com.ociojaen.backend.services;

import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.ociojaen.backend.models.Evento;
import com.ociojaen.backend.models.Participacion;
import com.ociojaen.backend.models.Usuario;
import com.ociojaen.backend.repos.EventoRepository;
import com.ociojaen.backend.repos.ParticipacionRepository;
import com.ociojaen.backend.repos.UsuarioRepository;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;

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

    @Transactional
    public void generarPdfParticipantesDelEvento(
            Long eventoId, String organizadorUsername, HttpServletResponse response) throws IOException {
        Evento evento = eventoRepo.findById(eventoId).orElseThrow();
        // Optional: validar que el usuario actual tiene permisos...

        List<Usuario> participantes = participacionRepo.findByEventoId(eventoId)
                .stream()
                .map(Participacion::getUsuario)
                .toList();

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition",
                "attachment; filename=participantes_evento_" + evento.getNombre() + ".pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        try {
            Image logo = Image.getInstance(getClass().getResource("/static/logo.png"));
            logo.scaleToFit(100, 100);

            float x = document.right() - 100; 
            float y = document.top() - 60; 
            logo.setAbsolutePosition(x, y);

            document.add(logo);
        } catch (Exception e) {
            System.err.println("No se pudo cargar el logo: " + e.getMessage());
        }

        Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Font.BOLD);
        document.add(new Paragraph("Evento: " + evento.getNombre(), boldFont));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Participantes:", boldFont));
        document.add(new Paragraph(" "));

        for (Usuario u : participantes) {
            document.add(new Paragraph("- " + u.getUsername() + " (" + u.getEmail() + ")"));
        }

        document.close();
    }

}
