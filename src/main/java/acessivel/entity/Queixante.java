package acessivel.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity(name = "Queixante")
@Table(name = "queixante")
//@EqualsAndHashCode(of = "id_queixante")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Queixante extends Usuario{
    @Id
    @Column(name = "id_queixante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_queixante;

    @Column(name = "cad_pcd")
    private String cad_pcd;

    @ManyToOne()
    private Endereco endereco;
}
