package acessivel.dto.queixante;

import acessivel.dto.usuario.CriarUsuarioDTO;
import jakarta.persistence.Basic;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarQueixanteDTO extends CriarUsuarioDTO {

    @NotBlank
    @CPF
    private String cpf;

    @Basic
    @Temporal(TemporalType.DATE)
    private LocalDate dataNascimento;

}
