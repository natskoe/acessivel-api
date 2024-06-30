package acessivel.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;


@Entity(name = "Queixante")
@Table(name = "queixante")
//@EqualsAndHashCode(of = "id_queixante")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Queixante extends Usuario {
    @Id
    @Column(name = "id_queixante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQueixante;

    @Column(name = "cad_pcd")
    private String cadPcd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_endereco_id_endereco")
    private Endereco endereco;
}