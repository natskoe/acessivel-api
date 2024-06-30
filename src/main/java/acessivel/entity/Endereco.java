package acessivel.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name = "Endereco")
@Table(name = "endereco")
@EqualsAndHashCode(of = "id_endereco")
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id
    @Column(name = "id_endereco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

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
