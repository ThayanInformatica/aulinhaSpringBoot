package com.aulinha.aulinha.Service;


import com.aulinha.aulinha.Domain.Anuncio;
import com.aulinha.aulinha.Domain.Usuario;
import com.aulinha.aulinha.Repository.AnuncioRepository;
import com.aulinha.aulinha.Util.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service
@Transactional

public class AnuncioServiceImpl implements AnuncioService{


    @Autowired
    private AnuncioRepository anuncioRepository;

    public AnuncioServiceImpl(AnuncioRepository anuncioRepository) {
        this.anuncioRepository = anuncioRepository;
    }


    @Transactional(propagation = REQUIRED)
    @Override
    public Anuncio AdicionarAnuncio(Anuncio anuncio, Usuario usuario) {

        anuncio.setUsuario(usuario);

        return anuncioRepository.saveAndFlush(anuncio);
    }

    @Override
    public List<Anuncio> RecuperarTodosAnuncio() {

        List<Anuncio> anuncio = anuncioRepository.findAll();

        if (anuncio == null) {
            new ArrayList<>();
        }

        return anuncio;
    }

    @Override
    @Transactional(propagation = REQUIRED)
    public void DeletarAnuncio(Long id_anuncio, Long id_usuario) {

        Anuncio anuncio = anuncioRepository.VerificarSeUsuarioeDoAnuncio(id_anuncio, id_usuario);

        if (anuncio == null) {
            throw new RecursoNaoEncontradoException();
        }

        anuncioRepository.deleteById(id_anuncio);

    }


    @Override
    @Transactional(propagation = REQUIRED)
    public Optional<Anuncio> recuperarAnuncioPorId(Long id_anuncio) {

        Optional<Anuncio> anuncio = anuncioRepository.findById(id_anuncio);
        if (anuncio == null) {
            throw new RecursoNaoEncontradoException();
        }

        return anuncio;

    }



}
