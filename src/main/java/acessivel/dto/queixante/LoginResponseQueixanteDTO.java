package acessivel.dto.queixante;

import acessivel.entity.Queixante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseQueixanteDTO {
    private String token;

    private long expiresIn;

    private Queixante queixante;
}
