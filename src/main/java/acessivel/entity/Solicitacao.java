package acessivel.entity;


import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitacao {

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "local")
    private String local;

    @Column(name = "queixante")
    private Queixante queixante;

    @Column(name = "status")
    private boolean status;
}
