package acessivel.controller;

import acessivel.dto.queixante.AdicionarCadPcdDTO;
import acessivel.dto.queixante.CriarQueixanteDTO;
import acessivel.entity.Queixante;
import acessivel.service.QueixanteService;
import jakarta.validation.Valid;
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

    @CrossOrigin(origins = "*")
    @GetMapping("/get")
    public ResponseEntity<?> getQueixantes(){
        List<Queixante> listaQueixantes = queixanteService.getQueixantes();
        return new ResponseEntity<>(listaQueixantes, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get/{codigo}")
    public ResponseEntity<?> getQueixantePorCodigo(@PathVariable Long codigo) {
        Queixante queixante = queixanteService.getQueixantePorCodigo(codigo);
        return new ResponseEntity<>(queixante, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/post")
    public ResponseEntity<?> postQueixante(@RequestBody @Valid CriarQueixanteDTO data){
        Queixante queixante = queixanteService.criarQueixante(data);
        return new ResponseEntity<>(queixante, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PatchMapping("/patch/cadpcd")
    public ResponseEntity<?> patchQueixante(@RequestBody @Valid AdicionarCadPcdDTO data){
        Queixante queixante = queixanteService.patchQueixanteCadPcd(data);
        return new ResponseEntity<>(queixante, HttpStatus.CREATED);
    }

}
