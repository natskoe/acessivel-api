package acessivel.service;

import acessivel.dto.endereco.CriarEnderecoDTO;
import acessivel.entity.Endereco;
import acessivel.entity.Queixante;
import acessivel.repository.QueixanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import acessivel.repository.EnderecoRepository;

import java.util.List;

@Service
public class EnderecoService {

    private EnderecoRepository repository;
    private QueixanteService queixanteService;

    public EnderecoService(EnderecoRepository repository, QueixanteService queixanteService) {
        this.repository = repository;
        this.queixanteService = queixanteService;
    }

    public Endereco salvarEndereco(Endereco endereco){
        Endereco enderecoSalvo = repository.save(endereco);
        return enderecoSalvo;
    }

    //Retornar todos os usuários.
    public List<Endereco> getEnderecos(){
        return repository.findAll();
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

        Endereco enderecoSalvo = salvarEndereco(endereco);
        System.out.println("Endereço salvo: " + enderecoSalvo);

        Long id_queixante = data.getId_queixante();

        queixanteService.patchQueixanteEndereco(id_queixante, enderecoSalvo);

        return enderecoSalvo;
    }
}
