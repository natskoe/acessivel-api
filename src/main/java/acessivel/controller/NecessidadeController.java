package acessivel.controller;

import acessivel.dto.necessidade.CriarNecessidadeDTO;
import acessivel.entity.Necessidade;
import acessivel.entity.Queixa;
import acessivel.service.NecessidadeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/necessidade")
public class NecessidadeController {

    private final NecessidadeService necessidadeService;

    public NecessidadeController(NecessidadeService necessidadeService) {
        this.necessidadeService = necessidadeService;
    }

    @CrossOrigin("*")
    @GetMapping("/get")
    public ResponseEntity<?> getNecessidades(){
        List<Necessidade> necessidades = necessidadeService.getNecessidades();
        return new ResponseEntity<>(necessidades, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @GetMapping("/get/{codigo}")
    public ResponseEntity<?> getNecessidade(@PathVariable Long codigo){
        Necessidade necessidade = necessidadeService.getNecessidadePorCodigo(codigo);
        return new ResponseEntity<>(necessidade, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @GetMapping("/get/queixante/{codigo}")
    public ResponseEntity<?> getNecessidadesPorQueixante(@PathVariable Long codigo){
        List<Necessidade> listaNecessidades = necessidadeService.getNecessidadesPorQueixante(codigo);
        return new ResponseEntity<>(listaNecessidades, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/post")
    public ResponseEntity<?> postNecessidade(@RequestBody @Valid CriarNecessidadeDTO data){
        Necessidade necessidade = necessidadeService.criarNecessidade(data);
        return new ResponseEntity<>(necessidade, HttpStatus.CREATED);
    }
}
