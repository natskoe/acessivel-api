package acessivel.controller;

import acessivel.dto.necessidade.CriarNecessidadeDTO;
import acessivel.entity.Necessidade;
import acessivel.service.NecessidadeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/necessidade")
public class NecessidadeController {

    private final NecessidadeService necessidadeService;

    public NecessidadeController(NecessidadeService necessidadeService) {
        this.necessidadeService = necessidadeService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/post")
    public ResponseEntity<?> postNecessidade(@RequestBody @Valid CriarNecessidadeDTO data){
        Necessidade necessidade = necessidadeService.criarNecessidade(data);
        return new ResponseEntity<>(necessidade, HttpStatus.CREATED);
    }
}
