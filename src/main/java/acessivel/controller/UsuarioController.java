package acessivel.controller;

import acessivel.dtos.usuario.CriarUsuarioDTO;
import acessivel.entity.Usuario;
import acessivel.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<?> getUsuarios(){
        List<Usuario> listaUsuarios = usuarioService.getUsuarios();
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postUsuario(@RequestBody CriarUsuarioDTO data){
        Usuario usuario = usuarioService.criarUsuario(data);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }
}
