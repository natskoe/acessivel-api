package acessivel.entity;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(of = "id_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Column(name = "id_usuario")
    private int id_usuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "dataNascimento")
    private Date dataNascimento;
}
