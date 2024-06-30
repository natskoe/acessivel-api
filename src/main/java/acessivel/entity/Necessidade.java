package acessivel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "Necessidade")
@Table(name = "necessidade")
@Data
@EqualsAndHashCode(of = "id_necessidade")
@NoArgsConstructor
@AllArgsConstructor
public class Necessidade extends Solicitacao{

    @Id
    @Column(name = "id_necessidade")
    private Long idNecessidade;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "cronica")
    private boolean cronica;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "fk_queixante_id_queixante")
    private Queixante queixante;
}