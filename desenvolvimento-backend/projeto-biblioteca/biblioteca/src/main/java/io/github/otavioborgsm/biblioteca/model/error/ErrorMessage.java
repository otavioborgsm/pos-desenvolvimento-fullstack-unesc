package io.github.otavioborgsm.biblioteca.model.error;

public class ErrorMessage {
    private String titutlo;
    private Integer status;
    private String mensagem;

    public String getTitutlo() {
        return titutlo;
    }

    public void setTitutlo(String titutlo) {
        this.titutlo = titutlo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public ErrorMessage(String titutlo, Integer status, String mensagem) {
        this.titutlo = titutlo;
        this.status = status;
        this.mensagem = mensagem;
    }

    
}
