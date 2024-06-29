package acessivel.dto.queixante;

import acessivel.dto.usuario.CriarUsuarioDTO;
import acessivel.entity.Endereco;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarQueixanteDTO extends CriarUsuarioDTO {

    private String cadPcd;
    private Endereco endereco;

}
