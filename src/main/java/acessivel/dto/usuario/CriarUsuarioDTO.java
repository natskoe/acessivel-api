package acessivel.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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

    @NotBlank(message = "Senha não pode estar vazio.")
    private String senha;
}
