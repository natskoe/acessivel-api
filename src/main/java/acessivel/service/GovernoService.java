package acessivel.service;

import acessivel.dto.governo.CriarGovernoDTO;
import acessivel.entity.Governo;
import acessivel.repository.GovernoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GovernoService {

    @Autowired
    private GovernoRepository repository;

    // GET - Retornar todos os usuários
    public List<Governo> getGoverno() {
        return repository.findAll();
    }

    // POST - Criar um usuário governo.
    public Governo criarGoverno(CriarGovernoDTO data){
        Governo governo = new Governo();

        governo.setNome(data.getNome());
        governo.setSobrenome(data.getSobrenome());
        governo.setCpf(data.getCpf());
        governo.setEmail(data.getEmail());
        governo.setSenha(data.getSenha());
        governo.setDataNascimento(data.getDataNascimento());
        governo.setMatricula(data.getMatricula());

        repository.save(governo);
        return governo;
    }
    // DELETE - Remover um usuário governo.
    public ResponseEntity<?> removerGoverno(long id){
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
