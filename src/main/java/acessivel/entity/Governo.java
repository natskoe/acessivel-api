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
    private int id_governo;

    @Column(name = "matricula")
    private String matricula;
}
