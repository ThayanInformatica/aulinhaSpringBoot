package com.aulinha.aulinha.Service;

import com.aulinha.aulinha.Domain.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioService {

    Usuario adicionarouAlterarUsuario(Usuario usuario);

    void removerUsuario(Long id);

    List<Usuario> recuperarTodosUsuario();

}
