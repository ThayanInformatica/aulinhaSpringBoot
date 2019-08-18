package com.aulinha.aulinha.Repository;

import com.aulinha.aulinha.Domain.Anuncio;
import com.aulinha.aulinha.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository  extends JpaRepository<Anuncio, Long>, QueryByExampleExecutor<Anuncio> {

    @Query(value = "SELECT a " +
            " FROM Anuncio a " +
            "LEFT JOIN a.usuario u" +
            " where a.id = :id_anuncio and u.id = :id_usuario")
    Anuncio VerificarSeUsuarioeDoAnuncio(@Param("id_anuncio") Long id_anuncio,@Param("id_usuario") Long id_usuario);

}

