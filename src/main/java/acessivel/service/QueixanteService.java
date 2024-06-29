package acessivel.service;

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

        return salvarQueixante(queixante);
    }

    //Salvar usuário.
    public Queixante salvarQueixante(Queixante queixante) {
        return repository.save(queixante);
    }

    //Buscar um usuário por código.
    public Queixante getQueixantePorCodigo(Long id) {
        Queixante queixante = repository.findById(id).get();
        return queixante;
    }

    //Vincular endereço ao queixante.
    public void patchQueixanteEndereco(Long id, Endereco endereco) {
        Queixante queixante = repository.getReferenceById(id);
        queixante.setEndereco(endereco);

        repository.save(queixante);
    }
}