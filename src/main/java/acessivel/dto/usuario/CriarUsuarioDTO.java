package acessivel.dto.usuario;

import jakarta.persistence.Basic;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    @Basic
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
}
