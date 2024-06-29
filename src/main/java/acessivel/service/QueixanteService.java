package acessivel.service;

import acessivel.dto.queixante.AtualizarEnderecoQueixanteDTO;
import acessivel.dto.queixante.CriarQueixanteDTO;
import acessivel.entity.Endereco;
import acessivel.entity.Queixante;
import acessivel.repository.QueixanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QueixanteService {

    @Autowired
    private QueixanteRepository repository;

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
    public Queixante patchQueixanteEndereco(AtualizarEnderecoQueixanteDTO data) {
        Queixante queixante = repository.getReferenceById(data.getIdQueixante());

        if (data.getEndereco() != null) {
            queixante.setEndereco(data.getEndereco());
        }

        repository.save(queixante);
        return queixante;
    }
}