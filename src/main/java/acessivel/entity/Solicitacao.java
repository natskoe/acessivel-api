package acessivel.entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class Solicitacao {

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "status")
    private boolean status;
}
