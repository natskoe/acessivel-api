package acessivel.dto.necessidade;

import acessivel.dto.solicitacao.CriarSolicitacaoDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CriarNecessidadeDTO extends CriarSolicitacaoDTO {

    private Boolean cronica;

    @NotBlank(message = "O tipo não pode estar vazio.")
    private String tipo;
}
