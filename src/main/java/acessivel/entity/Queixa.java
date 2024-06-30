package acessivel.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private String imagemLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "fk_queixante_id_queixante")
    private Queixante queixante;

}
