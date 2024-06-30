package acessivel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

}
