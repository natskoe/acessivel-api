package acessivel.dto.queixante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginQueixanteDTO {
    private String email;
    private String password;
}
