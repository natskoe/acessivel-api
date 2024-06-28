package acessivel.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.internal.log.SubSystemLogging;

import java.time.LocalDate;
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

    @Column(name = "data_nascimento")
    @Basic
    @Temporal(TemporalType.DATE)
    private LocalDate dataNascimento;

}
