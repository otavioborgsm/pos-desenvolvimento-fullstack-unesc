package unesc.uol.precofipeapp.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Modelo implements Serializable {

    private List<Items> modelos;

    public List<Items> getModelos() {
        return modelos;
    }

    public void setModelos(ArrayList<Items> modelos) {
        this.modelos = modelos;
    }

    public static class Items {
        private String nome;
        private int codigo;

        public Items() {
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
}
