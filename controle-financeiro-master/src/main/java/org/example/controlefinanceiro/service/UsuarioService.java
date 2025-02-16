package org.example.controlefinanceiro.service;

import org.example.controlefinanceiro.model.Usuario;
import org.example.controlefinanceiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            throw new IllegalArgumentException("E-mail já cadastrado!");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario validarLogin(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }

    public boolean emailJaCadastrado(String email) {
        return usuarioRepository.findByEmail(email) != null;
    }
}