package com.ociojaen.backend.services;

import com.ociojaen.backend.models.Rol;
import com.ociojaen.backend.models.Usuario;
import com.ociojaen.backend.repos.UsuarioRepository;
import com.ociojaen.backend.security.JwtService;
import com.ociojaen.backend.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String registrar(String username, String email, String password) {
    Usuario user = new Usuario();
    user.setUsername(username);
    user.setEmail(email);
    user.setEnabled(true);
    user.setPassword(passwordEncoder.encode(password));
    user.setTipo(Rol.USUARIO); // Siempre USUARIO al registrarse
    usuarioRepo.save(user);
    return jwtService.generateToken(new UserDetailsImpl(user));
}


    public String login(String username, String password) {
        Usuario user = usuarioRepo.findByUsername(username).orElseThrow();
        if (!passwordEncoder.matches(password, user.getPassword())) throw new RuntimeException("Credenciales inválidas");
        return jwtService.generateToken(new UserDetailsImpl(user));
    }
}