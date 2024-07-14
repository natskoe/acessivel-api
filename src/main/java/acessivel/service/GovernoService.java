package acessivel.service;

import acessivel.dto.governo.AtualizarGovernoDTO;
import acessivel.dto.governo.CriarGovernoDTO;
import acessivel.dto.queixante.LoginQueixanteDTO;
import acessivel.entity.Governo;
import acessivel.entity.Queixante;
import acessivel.repository.GovernoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GovernoService {

    private final GovernoRepository repository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public GovernoService(GovernoRepository repository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public Governo autenticar(LoginQueixanteDTO input){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return repository.findByEmail(input.getEmail())
                .orElseThrow();
    }

    //Salvar usuário governamental.
    public void salvarGoverno(Governo governo) {
        repository.save(governo);
    }

    //Buscar um usuário governamental por código.
    public Governo getGovernoPorCodigo(Long id) {return repository.findById(id).get();}

    //Retornar todos os usuários governamentais.
    public List<Governo> getAllGoverno() {
        return repository.findAll();
    }

    //Criar um usuário governamental a partir de um DTO.
    public Governo criarGoverno(CriarGovernoDTO data){
        Governo governo = new Governo();

        governo.setNome(data.getNome());
        governo.setSobrenome(data.getSobrenome());
        governo.setEmail(data.getEmail());
        governo.setPassword("");
        governo.setMatricula(data.getMatricula());
        governo.setAtivo(Boolean.FALSE);
        governo.setCpf(data.getCpf());
        governo.setDataNascimento(data.getDataNascimento());

        salvarGoverno(governo);
        return getGovernoPorCodigo(governo.getIdGoverno());
    }

    //Atualizar status de ativo ou não de um usuário governamental.
    public Governo atualizarAtivo(AtualizarGovernoDTO data){
        Governo governo = getGovernoPorCodigo(data.getIdGoverno());
        governo.setAtivo(Boolean.TRUE);
        governo.setPassword(data.getSenha());

        salvarGoverno(governo);
        return getGovernoPorCodigo(data.getIdGoverno());
    }
}
