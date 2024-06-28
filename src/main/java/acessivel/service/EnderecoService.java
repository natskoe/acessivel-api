package acessivel.service;

import acessivel.dto.endereco.CriarEnderecoDTO;
import acessivel.entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import acessivel.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public void salvarEndereco(Endereco endereco){
        repository.save(endereco);
    }

    public Endereco criarEndereco(CriarEnderecoDTO data) {
        Endereco endereco = new Endereco();

        endereco.setCep(data.getCep());
        endereco.setLogradouro(data.getLogradouro());
        endereco.setBairro(data.getBairro());
        endereco.setCidade(data.getCidade());
        endereco.setEstado(data.getEstado());
        endereco.setComplemento(data.getComplemento());
        endereco.setNumero(data.getNumero());

        salvarEndereco(endereco);
        return endereco;
    }
}
