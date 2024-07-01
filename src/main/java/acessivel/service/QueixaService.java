package acessivel.service;

import acessivel.dto.queixa.CriarQueixaDTO;
import acessivel.entity.Queixa;
import acessivel.entity.Queixante;
import acessivel.repository.QueixaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueixaService {

    private final QueixaRepository repository;
    private final QueixanteService queixanteService;

    public QueixaService(QueixaRepository repository, QueixanteService queixanteService){
        this.repository = repository;
        this.queixanteService = queixanteService;
    }

    //Salvar Queixa.
    public Queixa salvarQueixa(Queixa queixa){
        return repository.save(queixa);
    }

    //Retornar Queixa por código.
    public Queixa getQueixaPorCodigo(Long codigo){
        return repository.findById(codigo).get();
    }

    //Retornar todas as queixas.
    public List<Queixa> getQueixas(){
        return repository.findAll();
    }

    //Retornar todas as queixas de um Queixante.
    public List<Queixa> getQueixasPorQueixante(Long idQueixante){
        Queixante queixante = queixanteService.getQueixantePorCodigo(idQueixante);

        return repository.findAllByQueixante(queixante);
    }

    //Criar queixa a partir de um DTO.
    public Queixa criarQueixa(CriarQueixaDTO data){
        Queixa queixa = new Queixa();

        Queixante queixante = queixanteService.getQueixantePorCodigo(data.getIdQueixante());

        queixa.setQueixante(queixante);
        queixa.setTitulo(data.getTitulo());
        queixa.setDescricao(data.getDescricao());
        queixa.setLocalizacao(data.getLocalizacao());
        queixa.setStatus(Boolean.FALSE);

        queixa.setImagemLink(data.getImagemLink());

        Queixa queixaSalva = salvarQueixa(queixa);
        getQueixaPorCodigo(queixa.getIdQueixa());

        return queixaSalva;
    }
}
