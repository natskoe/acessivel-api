package acessivel.dto.usuario;

import jakarta.persistence.Basic;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarUsuarioDTO {

    @NotBlank(message = "Nome não pode estar vazio.")
    private String nome;

    @NotBlank(message = "Sobrenome não pode estar vazio.")
    private String sobrenome;

    @NotBlank(message = "Email não pode estar vazio.")
    @Email
    private String email;

    @NotBlank(message = "CPF não pode estar vazio.")
    @CPF
    private String cpf;

    @Basic
    @Temporal(TemporalType.DATE)
    private LocalDate dataNascimento;

}
