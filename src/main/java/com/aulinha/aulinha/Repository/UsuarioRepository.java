package com.aulinha.aulinha.Repository;

import com.aulinha.aulinha.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
    public interface UsuarioRepository extends JpaRepository<Usuario, Long>, QueryByExampleExecutor<Usuario> {



    @Query(value = "SELECT u " +
            " FROM Usuario u " +
            " where u.id = :id_usuario")
    Usuario recuperarUsuarioPorID(@Param("id_usuario") Long id_usuario);


    }
