package com.aulinha.aulinha.Controller;


import com.aulinha.aulinha.Domain.Anuncio;
import com.aulinha.aulinha.Domain.Usuario;
import com.aulinha.aulinha.Repository.UsuarioRepository;
import com.aulinha.aulinha.Service.AnuncioService;
import com.aulinha.aulinha.Util.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/anuncio")
public class AnuncioController {

    @Autowired
    private AnuncioService anuncioService;
    private UsuarioRepository usuarioRepository;

    public AnuncioController(AnuncioService anuncioService, UsuarioRepository usuarioRepository) {
        this.anuncioService = anuncioService;
        this.usuarioRepository = usuarioRepository;
    }


    @PostMapping("/{id_usuario}")
    public ResponseEntity<Anuncio> SalvarAnuncio(@RequestBody Anuncio anuncio, @PathVariable Long id_usuario) {

        Usuario usuario = usuarioRepository.recuperarUsuarioPorID(id_usuario);

        if (usuario.getId() == null) {
            throw new RecursoNaoEncontradoException();
        }

        Anuncio anuncioIns = anuncioService.AdicionarAnuncio(anuncio, usuario);

        return new ResponseEntity<>(anuncioIns, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Anuncio>> RecuperarTodosAnuncios() {

        List<Anuncio> anuncio = anuncioService.RecuperarTodosAnuncio();

        return ResponseEntity.ok(anuncio);

    }

    @DeleteMapping("/{id_usuario}/{id_anuncio}")
    public ResponseEntity RemoverAnuncio(@PathVariable Long id_anuncio, @PathVariable Long id_usuario) {

        anuncioService.DeletarAnuncio(id_anuncio, id_usuario);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/id/{id_anuncio}")
    public ResponseEntity<Optional<Anuncio>> RecuperarAnuncioPorId(@PathVariable Long id_anuncio) {

        Optional<Anuncio> anuncio = anuncioService.recuperarAnuncioPorId(id_anuncio);

        return ResponseEntity.ok(anuncio);
    }

}
