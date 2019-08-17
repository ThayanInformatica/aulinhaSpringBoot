package com.aulinha.aulinha.Repository;

import com.aulinha.aulinha.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
    public interface UsuarioRepository extends JpaRepository<Usuario, Long>, QueryByExampleExecutor<Usuario> {

    }
