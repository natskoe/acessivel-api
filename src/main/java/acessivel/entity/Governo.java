package acessivel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private int id_governo;

    @Column(name = "matricula")
    private String matricula;
}
