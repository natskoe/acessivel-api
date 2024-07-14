package acessivel.controller;

import acessivel.dto.queixante.AdicionarCadPcdDTO;
import acessivel.dto.queixante.CriarQueixanteDTO;
import acessivel.dto.queixante.LoginQueixanteDTO;
import acessivel.dto.queixante.LoginResponseQueixanteDTO;
import acessivel.entity.Queixante;
import acessivel.service.JwtService;
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
    private final JwtService jwtService;
    private final QueixanteService queixanteService;

    @Autowired
    public QueixanteController(QueixanteService queixanteService, JwtService jwtService) {
        this.queixanteService = queixanteService;
        this.jwtService = jwtService;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponseQueixanteDTO> autenticar(@RequestBody LoginQueixanteDTO data){
        Queixante queixante = queixanteService.autenticar(data);
        String jwtToken = jwtService.gerarToken(queixante);
        LoginResponseQueixanteDTO response = new LoginResponseQueixanteDTO();
        response.setToken(jwtToken);
        response.setExpiresIn(jwtService.pegarTempoExpiracao());
        response.setQueixante(queixante); // isso deve ta errado
        return ResponseEntity.ok(response);
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
    @PostMapping("/auth/post")
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
