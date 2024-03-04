package br.gov.sp.fatec.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot.entity.Usuario;
import br.gov.sp.fatec.springboot.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {
    @Autowired
    private  UsuarioService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Usuario cadastraUsuario(@RequestBody Usuario usuario) {
        return service.cadastraUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> buscarTodosUsuarios() {
        return service.buscarTodosUsuarios();
    }

    @GetMapping(value = "/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable("id") Long id) {
        return service.buscarUsuarioPorId(id);
    }
    
}