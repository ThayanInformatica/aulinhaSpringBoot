package com.aulinha.aulinha.Service;


import com.aulinha.aulinha.Domain.Usuario;
import com.aulinha.aulinha.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service
@Transactional

public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private final UsuarioRepository usuarioRepository;


    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Usuario adicionarouAlterarUsuario(Usuario usuario) {

          return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional(propagation = REQUIRED)
    public void removerUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
