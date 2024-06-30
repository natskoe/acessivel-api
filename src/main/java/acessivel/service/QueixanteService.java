package acessivel.service;

import acessivel.dto.queixante.AdicionarCadPcdDTO;
import acessivel.dto.queixante.CriarQueixanteDTO;
import acessivel.entity.Endereco;
import acessivel.entity.Queixante;
import acessivel.repository.QueixanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QueixanteService {

    private QueixanteRepository repository;

    public QueixanteService(QueixanteRepository repository) {
        this.repository = repository;
    }

    //Salvar usuário.
    public void salvarQueixante(Queixante queixante) {
        repository.save(queixante);
    }

    //Buscar um usuário por código.
    public Queixante getQueixantePorCodigo(Long id) {
        return repository.findById(id).get();
    }

    //Retornar todos os usuários.
    public List<Queixante> getQueixantes() {
        return repository.findAll();
    }

    //Criar um queixante a partir de um DTO.
    public Queixante criarQueixante(CriarQueixanteDTO data) {
        Queixante queixante = new Queixante();

        queixante.setSenha(data.getSenha());
        queixante.setNome(data.getNome());
        queixante.setSobrenome(data.getSobrenome());
        queixante.setEmail(data.getEmail());
        queixante.setCpf(data.getCpf());
        queixante.setCadPcd(data.getCadPcd());
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