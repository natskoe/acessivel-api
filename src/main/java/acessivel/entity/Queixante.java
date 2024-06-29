package acessivel.entity;

import acessivel.roles.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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
    private Long id_queixante;

    @Column(name = "cad_pcd")
    private String cadPcd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "queixantes_roles",
            joinColumns = @JoinColumn(name = "id_queixante"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<Role> roles;
}