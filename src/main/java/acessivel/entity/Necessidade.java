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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNecessidade;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "cronica")
    private Boolean cronica;

    @ManyToOne()
    @JoinColumn(name = "fk_queixante_id_queixante")
    private Queixante queixante;
}