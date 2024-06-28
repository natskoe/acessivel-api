package acessivel.controller;

import acessivel.dto.endereco.CriarEnderecoDTO;
import acessivel.entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import acessivel.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {


    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {this.enderecoService = enderecoService;}

    @CrossOrigin(origins = "*")
    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody CriarEnderecoDTO data) {

        Endereco endereco = enderecoService.criarEndereco(data);
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);

    }
}

