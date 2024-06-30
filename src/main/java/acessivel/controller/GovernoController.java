package acessivel.controller;

import acessivel.dto.governo.CriarGovernoDTO;
import acessivel.entity.Governo;
import acessivel.service.GovernoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/governo")
public class GovernoController {

    private final GovernoService governoService;

    @Autowired
    public GovernoController(GovernoService governoService) {
        this.governoService = governoService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get")
    public ResponseEntity<?> getGovernos(){
        List<Governo> listaGoverno = governoService.getAllGoverno();
        return new ResponseEntity<>(listaGoverno, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get/{codigo}")
    public ResponseEntity<?> getGovernoPorCodigo(@PathVariable Long codigo){
        Governo governo = governoService.getGovernoPorCodigo(codigo);
        return new ResponseEntity<>(governo, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/post")
    public ResponseEntity<?> postGoverno(@RequestBody @Valid CriarGovernoDTO data){
        Governo governo = governoService.criarGoverno(data);
        return new ResponseEntity<>(governo, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PatchMapping("/patch/ativo")
    public ResponseEntity<?> postGoverno(@RequestBody @Valid Long id){
        Governo governo = governoService.atualizarAtivo(id);
        return new ResponseEntity<>(governo, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = {"delete/{id}"})
    public ResponseEntity<?> deleteGoverno(@PathVariable Long id){
        return new ResponseEntity<>(governoService.removerGoverno(id), HttpStatus.OK);
    }
}
