package acessivel.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Queixa")
@Table(name = "queixa")
@Data
@EqualsAndHashCode(of = "id_usuario")
@NoArgsConstructor
@AllArgsConstructor
public class Queixa extends Solicitacao {

    @Id
    @Column(name = "id_queixa")
    private Long id_queixa;

    @Column(name = "imagem_link")
    private String imagem_link;
}
