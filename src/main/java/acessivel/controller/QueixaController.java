package acessivel.controller;

import acessivel.dto.queixa.CriarQueixaDTO;
import acessivel.entity.Queixa;
import acessivel.service.QueixaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/queixa")
public class QueixaController {

    private final QueixaService queixaService;

    public QueixaController(QueixaService queixaService) {
        this.queixaService = queixaService;
    }

    @CrossOrigin("*")
    @GetMapping("/get")
    public ResponseEntity<?> getQueixas(){
        List<Queixa> queixas = queixaService.getQueixas();
        return new ResponseEntity<>(queixas, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @GetMapping("/get/{codigo}")
    public ResponseEntity<?> getQueixa(@PathVariable Long codigo){
        Queixa queixa = queixaService.getQueixaPorCodigo(codigo);
        return new ResponseEntity<>(queixa, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @GetMapping("/get/queixante/{codigo}")
    public ResponseEntity<?> getQueixasporQueixante(@PathVariable Long codigo){
        List<Queixa> listaQueixas = queixaService.getQueixasPorQueixante(codigo);
        return new ResponseEntity<>(listaQueixas, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/post")
    public ResponseEntity<?> postQueixa(@RequestBody @Valid CriarQueixaDTO data){
        Queixa queixa = queixaService.criarQueixa(data);
        return new ResponseEntity<>(queixa, HttpStatus.CREATED);
    }

}
