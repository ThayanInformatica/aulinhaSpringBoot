package com.aulinha.aulinha.Service;

import com.aulinha.aulinha.Domain.Anuncio;
import com.aulinha.aulinha.Domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface AnuncioService {


    Anuncio AdicionarAnuncio(Anuncio anuncio, Usuario usuario);

    List<Anuncio> RecuperarTodosAnuncio();

    void DeletarAnuncio(Long id_anuncio, Long id_usuario);

    Optional<Anuncio> recuperarAnuncioPorId(Long id_anuncio);

}

