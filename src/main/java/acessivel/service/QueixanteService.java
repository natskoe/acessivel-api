package acessivel.service;

import acessivel.dto.queixante.AdicionarCadPcdDTO;
import acessivel.dto.queixante.CriarQueixanteDTO;
import acessivel.dto.queixante.LoginQueixanteDTO;
import acessivel.entity.Endereco;
import acessivel.entity.Queixante;
import acessivel.repository.QueixanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QueixanteService {

    private final QueixanteRepository repository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public QueixanteService(QueixanteRepository repository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    // Autenticar usuário queixante
    public Queixante autenticar(LoginQueixanteDTO input){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return repository.findByEmail(input.getEmail())
                .orElseThrow();
    }

    //Salvar usuário queixante.
    public void salvarQueixante(Queixante queixante) {
        repository.save(queixante);
    }

    //Buscar um usuário por código.
    public Queixante getQueixantePorCodigo(Long id) {
        return repository.findById(id).orElseGet(null);
    }

    //Retornar todos os usuários queixantes.
    public List<Queixante> getQueixantes() {
        return repository.findAll();
    }

    //Criar um usuário queixante a partir de um DTO.
    public Queixante criarQueixante(CriarQueixanteDTO data) {
        Queixante queixante = new Queixante();

        queixante.setPassword(passwordEncoder.encode(data.getPassword()));
        queixante.setNome(data.getNome());
        queixante.setSobrenome(data.getSobrenome());
        queixante.setEmail(data.getEmail());
        queixante.setCpf(data.getCpf());
        queixante.setDataNascimento(data.getDataNascimento());

        salvarQueixante(queixante);
        return getQueixantePorCodigo(queixante.getIdQueixante());
    }

    //Vincular endereço ao queixante.
    public Queixante patchQueixanteEndereco(Long id, Endereco endereco) {
        Queixante queixante = getQueixantePorCodigo(id);
        queixante.setEndereco(endereco);

        salvarQueixante(queixante);
        return getQueixantePorCodigo(id);
    }

    //Vincular cadpcd ao queixante.
    public Queixante patchQueixanteCadPcd(AdicionarCadPcdDTO data) {
        Queixante queixante = getQueixantePorCodigo(data.getIdQueixante());
        queixante.setCadPcd(data.getCadPcd());
        salvarQueixante(queixante);

        return getQueixantePorCodigo(data.getIdQueixante());
    }
}