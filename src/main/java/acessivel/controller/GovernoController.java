package acessivel.controller;

import acessivel.dto.governo.CriarGovernoDTO;
import acessivel.entity.Governo;
import acessivel.entity.Queixante;
import acessivel.service.GovernoService;
import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/governo")
public class GovernoController {

    private GovernoService governoService;

    @Autowired
    public GovernoController(GovernoService governoService) {
        this.governoService = governoService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get")
    public ResponseEntity<?> getGoverno(){
        List<Governo> listaGoverno = governoService.getGoverno();
        return new ResponseEntity<>(listaGoverno, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/post")
    public ResponseEntity<?> postGoverno(@RequestBody CriarGovernoDTO data){
        Governo governo = governoService.criarGoverno(data);
        return new ResponseEntity<>(governo, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = {"delete/{id}"})
    public ResponseEntity<?> deleteGoverno(@PathVariable Long id){
        return new ResponseEntity<>(governoService.removerGoverno(id), HttpStatus.OK, Headers.of("header:", ));
    }
}
