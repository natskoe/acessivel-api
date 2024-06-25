package acessivel.dtos.usuario;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarUsuarioDTO {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String senha;
    private Date dataNascimento;
}
