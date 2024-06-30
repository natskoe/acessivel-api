package acessivel.service;

import acessivel.dto.necessidade.CriarNecessidadeDTO;
import acessivel.entity.Necessidade;
import acessivel.entity.Queixante;
import acessivel.repository.NecessidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NecessidadeService {


    private NecessidadeRepository repository;
    private QueixanteService queixanteService;

    public NecessidadeService(NecessidadeRepository repository, QueixanteService queixanteService) {
        this.repository = repository;
        this.queixanteService = queixanteService;
    }

    //Salvar necessidade.
    public Necessidade salvarNecessidade(Necessidade necessidade){
        Necessidade necessidadeSalvo = repository.save(necessidade);
        return necessidadeSalvo;
    }

    //Buscar uma necessidade por código.
    public Necessidade getNecessidadePorCodigo(Long id) {return repository.findById(id).get();}

    //Retornar todas as necessidades.
    public List<Necessidade> getNecessidades(){
        return repository.findAll();
    }

    public Necessidade criarNecessidade(CriarNecessidadeDTO data){
        Necessidade necessidade = new Necessidade();

        Queixante queixante = queixanteService.getQueixantePorCodigo(data.getIdQueixante());

        necessidade.setQueixante(queixante);
        necessidade.setTitulo(data.getTitulo());
        necessidade.setDescricao(data.getDescricao());
        necessidade.setLocalizacao(data.getLocalizacao());
        necessidade.setStatus(Boolean.FALSE);
        necessidade.setTipo(data.getTipo());
        necessidade.setCronica(data.getCronica());

        Necessidade necessidadeSalva = salvarNecessidade(necessidade);
        getNecessidadePorCodigo(necessidade.getIdNecessidade());

        return necessidadeSalva;
    }

}
