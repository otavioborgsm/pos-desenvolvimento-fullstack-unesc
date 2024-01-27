package unesc.uol.precofipeapp.api.model;

import java.io.Serializable;

public class Ano implements Serializable {

    private String nome;
    private String codigo;

    public Ano() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
