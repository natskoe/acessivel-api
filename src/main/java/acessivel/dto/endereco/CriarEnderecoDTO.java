package acessivel.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CriarEnderecoDTO {

    @NotBlank(message = "CEP não pode estar vazio.")
    private String cep;

    @NotBlank(message = "Logradouro não pode estar vazio.")
    private String logradouro;

    @NotBlank(message = "Número não pode estar vazio.")
    private String numero;

    @NotBlank(message = "Complemento não pode estar vazio.")
    private String complemento;

    @NotBlank(message = "Bairro não pode estar vazio.")
    private String bairro;

    @NotBlank(message = "Cidade não pode estar vazio.")
    private String cidade;

    @NotBlank(message = "Estado não pode estar vazio.")
    private String estado;

}