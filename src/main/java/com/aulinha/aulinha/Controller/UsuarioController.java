package com.aulinha.aulinha.Controller;


import com.aulinha.aulinha.Domain.Usuario;
import com.aulinha.aulinha.Repository.UsuarioRepository;
import com.aulinha.aulinha.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository,
                             UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> RecuperarUsuarios() {

        List<Usuario> usuario = usuarioRepository.findAll();
        if (usuario == null)
            new ArrayList<>();

        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {

        Usuario usuarios = usuarioService.adicionarouAlterarUsuario(usuario);

        return new ResponseEntity<>(usuarios, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity removerUsuario(
         @PathVariable Long id) {

        usuarioService.removerUsuario(id);
        return ResponseEntity.ok().build();

    }

}