package acessivel.dto.usuario;

import jakarta.persistence.Basic;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarUsuarioDTO {

    @NotBlank(message = "Nome não pode estar vazio.")
    private String nome;

    @NotBlank(message = "Sobrenome não pode estar vazio.")
    private String sobrenome;

    @NotBlank(message = "CPF não pode estar vazio.")
    @Size(min = 11, max = 11)
    private String cpf;

    @NotBlank(message = "Email não pode estar vazio.")
    @Email
    private String email;

    @NotBlank(message = "Senha não pode estar vazio.")
    private String senha;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
}
