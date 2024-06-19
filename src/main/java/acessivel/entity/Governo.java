package acessivel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "Governo")
@Table(name = "governo")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Governo extends Usuario{

    private String matricula;

    public Governo(int id, String senha, String nome, String sobrenome, String email, String cpf, String matricula) {
        super(id, senha, nome, sobrenome, email, cpf);
        this.matricula = matricula;
    }
}
