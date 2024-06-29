package acessivel.dto.queixante;

import acessivel.entity.Endereco;
import lombok.Data;

@Data
public class AtualizarEnderecoQueixanteDTO {

    private Long codigo;
    private Endereco endereco;

}
