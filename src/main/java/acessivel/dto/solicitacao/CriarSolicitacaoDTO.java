package acessivel.dto.solicitacao;

import acessivel.entity.Queixante;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarSolicitacaoDTO {

    private Long id_queixante;

    @NotBlank(message = "Titulo não pode estar vazio.")
    private String titulo;

    @NotBlank(message = "Descricao não pode estar vazio.")
    private String descricao;

    @NotBlank(message = "Localização não pode estar vazia.")
    private String localizacao;

}