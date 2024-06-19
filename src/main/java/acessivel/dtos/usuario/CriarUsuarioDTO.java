package acessivel.dtos.usuario;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CriarUsuarioDTO {

    private String senha;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
}
