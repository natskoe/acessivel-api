package acessivel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity(name = "Endereco")
@Table(name = "endereco")
@Getter
@Setter
@EqualsAndHashCode(of = "id_endereco")
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id
    @Column(name = "id_endereco")
    private int id_endereco;

    @Column(name = "cep")
    private String cep;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;
}
