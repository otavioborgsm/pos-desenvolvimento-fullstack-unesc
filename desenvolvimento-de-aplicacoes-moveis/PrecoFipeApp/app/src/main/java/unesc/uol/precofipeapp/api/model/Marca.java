package unesc.uol.precofipeapp.api.model;

import java.io.Serializable;

public class Marca implements Serializable {

    private String nome;
    private int codigo;

    public Marca() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
