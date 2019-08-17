package com.aulinha.aulinha.Service;

import com.aulinha.aulinha.Domain.Usuario;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {

    Usuario adicionarouAlterarUsuario(Usuario usuario);

    void removerUsuario(Long id);


}
