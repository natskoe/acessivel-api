package acessivel.dto.governo;

import acessivel.dto.queixante.CriarQueixanteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarGovernoDTO extends CriarQueixanteDTO {

    
    private String matricula;
}
