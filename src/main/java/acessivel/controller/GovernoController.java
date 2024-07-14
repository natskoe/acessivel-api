package acessivel.controller;

import acessivel.dto.governo.AtualizarGovernoDTO;
import acessivel.dto.governo.CriarGovernoDTO;
import acessivel.dto.queixante.LoginQueixanteDTO;
import acessivel.dto.queixante.LoginResponseQueixanteDTO;
import acessivel.entity.Governo;
import acessivel.entity.Queixante;
import acessivel.service.GovernoService;
import acessivel.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/governo")
public class GovernoController {

    private final JwtService jwtService;
    private final GovernoService governoService;

    @Autowired
    public GovernoController(GovernoService governoService, JwtService jwtService) {
        this.governoService = governoService;
        this.jwtService = jwtService;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponseQueixanteDTO> autenticar(@RequestBody LoginQueixanteDTO data){
        Governo governo = governoService.autenticar(data);
        String jwtToken = jwtService.gerarToken(governo);
        LoginResponseQueixanteDTO response = new LoginResponseQueixanteDTO();
        response.setToken(jwtToken);
        response.setExpiresIn(jwtService.pegarTempoExpiracao());
        return ResponseEntity.ok(response);
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
    @PostMapping("/auth/post")
    public ResponseEntity<?> postGoverno(@RequestBody @Valid CriarGovernoDTO data){
        Governo governo = governoService.criarGoverno(data);
        return new ResponseEntity<>(governo, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PatchMapping("/patch")
    public ResponseEntity<?> postGoverno(@RequestBody @Valid AtualizarGovernoDTO data){
        Governo governo = governoService.atualizarAtivo(data);
        return new ResponseEntity<>(governo, HttpStatus.OK);
    }


}
