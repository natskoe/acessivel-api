package acessivel.service;

import acessivel.dtos.queixante.CriarQueixanteDTO;
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
    public List<Queixante> getQueixantes(){
        return repository.findAll();
    }

    //Criar um usuário.
    public Queixante criarQueixante(CriarQueixanteDTO data) {
        Queixante queixante = new Queixante();

        queixante.setSenha(data.getSenha());
        queixante.setNome(data.getNome());
        queixante.setSobrenome(data.getSobrenome());
        queixante.setEmail(data.getEmail());
        queixante.setCpf(data.getCpf());
        queixante.setCadPcd(data.getCadPcd());

        repository.save(queixante);
        return queixante;
    }
}
