package acessivel.dto.queixante;

import acessivel.dto.usuario.CriarUsuarioDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarQueixanteDTO extends CriarUsuarioDTO {

    @NotBlank(message = "Senha não pode estar vazio.")
    private String password;

}
