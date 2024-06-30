package acessivel.dto.queixa;

import acessivel.dto.solicitacao.CriarSolicitacaoDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarQueixaDTO extends CriarSolicitacaoDTO {

    @NotBlank(message = "O link da imagem não pode estar vazio.")
    private String imagemLink;
}
