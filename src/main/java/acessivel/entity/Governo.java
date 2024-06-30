package acessivel.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name = "Governo")
@Table(name = "governo")
@EqualsAndHashCode(of = "id_governo")
@NoArgsConstructor
@AllArgsConstructor
public class Governo extends Usuario{

    @Id
    @Column(name = "id_governo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGoverno;

    @Column(name = "matricula")
    private String matricula;

    @Column(name="ativo")
    private Boolean ativo;
}
