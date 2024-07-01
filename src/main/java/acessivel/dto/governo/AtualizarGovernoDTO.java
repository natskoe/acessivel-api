package acessivel.dto.governo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AtualizarGovernoDTO {

    public Long idGoverno;

    @NotBlank(message = "Senha não pode estar vazia.")
    private String senha;

}
