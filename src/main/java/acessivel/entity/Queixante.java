package acessivel.entity;

import lombok.Data;

@Data
public class Queixante extends Usuario{

    private String cadPcd;
    private Endereco endereco;

    public Queixante(int id, String senha, String nome, String sobrenome, String email, String cpf, String cadPcd, Endereco endereco) {
        super(id, senha, nome, sobrenome, email, cpf);
        this.cadPcd = cadPcd;
        this.endereco = endereco;
    }
}
