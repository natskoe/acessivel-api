package acessivel.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.internal.log.SubSystemLogging;

import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

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
    @Basic
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

}
