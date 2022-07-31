package argentinaprograma.portfolioweb.controller;

import argentinaprograma.portfolioweb.dto.JwtAuthResponseDTO;
import argentinaprograma.portfolioweb.dto.LoginDTO;
import argentinaprograma.portfolioweb.model.Rol;
import argentinaprograma.portfolioweb.model.Usuario;
import argentinaprograma.portfolioweb.repository.RolRepository;
import argentinaprograma.portfolioweb.repository.UsuarioRepository;
import argentinaprograma.portfolioweb.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@CrossOrigin
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/auth/login")
    public ResponseEntity<JwtAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generarToken(authentication);

        return ResponseEntity.ok(new JwtAuthResponseDTO(token));
    }

    @PostMapping("/auth/register")
    public Usuario registerUser(@RequestBody Usuario usuario) {

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return null;
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        Rol roles = rolRepository.findByNombre("ROLE_USER").get();
        usuario.setRoles(Collections.singleton(roles));

        Usuario usuarioCreado = usuarioRepository.save(usuario);

        return usuarioCreado;
    }
}
