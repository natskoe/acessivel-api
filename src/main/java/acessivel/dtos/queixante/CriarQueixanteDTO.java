package acessivel.dtos.queixante;

import acessivel.dtos.usuario.CriarUsuarioDTO;
import acessivel.entity.Endereco;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CriarQueixanteDTO extends CriarUsuarioDTO {

    private String cadPcd;
    private Endereco endereco;
}
