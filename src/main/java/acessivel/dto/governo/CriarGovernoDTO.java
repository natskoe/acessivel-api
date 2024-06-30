package acessivel.dto.governo;

import acessivel.dto.usuario.CriarUsuarioDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarGovernoDTO extends CriarUsuarioDTO {

    @NotBlank(message = "Matrícula não pode estar vazia.")
    private String matricula;

}
