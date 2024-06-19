package acessivel.service;

import acessivel.dtos.usuario.CriarUsuarioDTO;
import acessivel.entity.Usuario;
import acessivel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    //Retornar todos os usuários.
    public List<Usuario> getUsuarios(){
        return repository.findAll();
    }

    //Criar um usuário.
    public Usuario criarUsuario(CriarUsuarioDTO data) {
        Usuario usuario = new Usuario();

        usuario.setSenha(data.getSenha());
        usuario.setNome(data.getNome());
        usuario.setSobrenome(data.getSobrenome());
        usuario.setEmail(data.getEmail());
        usuario.setCpf(data.getCpf());

        repository.save(usuario);
        return usuario;
    }
}
