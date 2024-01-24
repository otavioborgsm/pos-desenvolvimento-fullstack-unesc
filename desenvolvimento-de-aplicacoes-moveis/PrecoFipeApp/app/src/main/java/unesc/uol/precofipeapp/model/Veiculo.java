package unesc.uol.precofipeapp.model;

public class Veiculo {

    private String nomeVeiculo;
    private int anoFabricacao;

    public Veiculo(final String nomeVeiculo, final int anoFabricacao) {
        this.nomeVeiculo = nomeVeiculo;
        this.anoFabricacao = anoFabricacao;
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
}
