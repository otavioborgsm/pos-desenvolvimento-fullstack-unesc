package unesc.uol.precofipeapp.database.model;

public class UsuarioModel {

    public static final String TABELA_NOME = "tb_usuario";
    public static final String
            COLUNA_ID = "_id",
            COLUNA_NOME_USUARIO = "nome_usuario",
            COLUNA_EMAIL_USUARIO = "email_usuario",
            COLUNA_SENHA_USUARIO = "senha_usuario";

    public static final String CRATE_TABLE =
            "create table " + TABELA_NOME
                + " ( "
                + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUNA_NOME_USUARIO + " text not null, "
                + COLUNA_EMAIL_USUARIO + " text not null, "
                + COLUNA_SENHA_USUARIO + " text not null );";

    public static final String DROP_TABLE = "drop table if exists " + TABELA_NOME;

    private Long id;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
}
