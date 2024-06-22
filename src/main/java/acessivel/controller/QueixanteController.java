package acessivel.controller;

import acessivel.dtos.queixante.CriarQueixanteDTO;
import acessivel.dtos.usuario.CriarUsuarioDTO;
import acessivel.entity.Queixante;
import acessivel.entity.Usuario;
import acessivel.service.QueixanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/queixante")
public class QueixanteController {

    private final QueixanteService queixanteService;

    @Autowired
    public QueixanteController(QueixanteService queixanteService) {
        this.queixanteService = queixanteService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getQueixantes(){
        List<Queixante> listaQueixantes = queixanteService.getQueixantes();
        return new ResponseEntity<>(listaQueixantes, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postQueixantes(@RequestBody CriarQueixanteDTO data){
        Queixante queixante = queixanteService.criarQueixante(data);
        return new ResponseEntity<>(queixante, HttpStatus.CREATED);
    }
}
