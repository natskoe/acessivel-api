package acessivel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "Usuario")
@Table(name = "usuario")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "Senha")
    private String senha;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Sobrenome")
    private String sobrenome;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

}
