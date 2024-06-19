package acessivel.entity;

import lombok.Data;

@Data
public class Necessidade extends Solicitacao{

    private String tipo;
    private boolean cronica;

    public Necessidade(String titulo, String descricao, String local, Queixante queixante, String tipo, boolean status, boolean cronica) {
        super(titulo, descricao, local, queixante, status);
        this.tipo = tipo;
        this.cronica = cronica;
    }
}
