package acessivel.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity(name = "Queixante")
@Table(name = "queixante")
@EqualsAndHashCode(of = "id_queixante")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Queixante extends Usuario{
    @Id
    @Column(name = "id_queixante")
    private int id_queixante;

    @Column(name = "cadPcd")
    private String cadPcd;

    @ManyToOne()
    private Endereco endereco;


}
