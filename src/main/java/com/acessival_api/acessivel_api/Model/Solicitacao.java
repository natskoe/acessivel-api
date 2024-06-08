package com.acessival_api.acessivel_api.Model;


import lombok.Data;

@Data
public class Solicitacao {
    private String titulo;
    private String descricao;
    private String local;
    private Queixante queixante;
    private boolean status;

    public Solicitacao(String titulo, String descricao, String local, Queixante queixante, boolean status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
        this.queixante = queixante;
        this.status = status;
    }
}
