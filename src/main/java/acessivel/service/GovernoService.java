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

    //Salvar usuário governamental.
    public void salvarGoverno(Governo governo) {
        repository.save(governo);
    }

    //Buscar um usuário governamental por código.
    public Governo getGovernoPorCodigo(Long id) {return repository.findById(id).get();}

    //Retornar todos os usuários governamentais.
    public List<Governo> getAllGoverno() {
        return repository.findAll();
    }

    //Criar um usuário governamental a partir de um DTO.
    public Governo criarGoverno(CriarGovernoDTO data){
        Governo governo = new Governo();

        governo.setNome(data.getNome());
        governo.setSobrenome(data.getSobrenome());
        governo.setEmail(data.getEmail());
        governo.setSenha(data.getSenha());
        governo.setMatricula(data.getMatricula());
        governo.setAtivo(Boolean.FALSE);

        salvarGoverno(governo);
        return getGovernoPorCodigo(governo.getIdGoverno());
    }

    //Atualizar status de ativo ou não de um usuário governamental.
    public Governo atualizarAtivo(Long id){
        Governo governo = getGovernoPorCodigo(id);
        governo.setAtivo(Boolean.TRUE);

        salvarGoverno(governo);
        return getGovernoPorCodigo(id);
    }

   //Remover um usuário governamental.
    public ResponseEntity<?> removerGoverno(Long id){
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
