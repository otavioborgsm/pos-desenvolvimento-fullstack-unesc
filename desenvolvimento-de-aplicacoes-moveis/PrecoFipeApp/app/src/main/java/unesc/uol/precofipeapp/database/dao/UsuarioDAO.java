package unesc.uol.precofipeapp.database.dao;

import android.content.ContentValues;
import android.content.Context;

import unesc.uol.precofipeapp.database.DBOpenHelper;
import unesc.uol.precofipeapp.database.model.UsuarioModel;

public class UsuarioDAO extends AbstractDAO{

    private String[] colunas = new String[]{
            UsuarioModel.COLUNA_ID,
            UsuarioModel.COLUNA_NOME_USUARIO,
            UsuarioModel.COLUNA_EMAIL_USUARIO,
            UsuarioModel.COLUNA_SENHA_USUARIO
    };

    public UsuarioDAO(Context context) {
        db_helper = new DBOpenHelper(context);
    }


    public long Insert(UsuarioModel model){

        long linhasInseridas = 0;

        ContentValues values = new ContentValues();
        values.put(UsuarioModel.COLUNA_NOME_USUARIO, model.getNomeUsuario());
        values.put(UsuarioModel.COLUNA_EMAIL_USUARIO, model.getEmailUsuario());
        values.put(UsuarioModel.COLUNA_SENHA_USUARIO, model.getSenhaUsuario());

        try {
            Open();

            linhasInseridas = db.insert(
                    UsuarioModel.TABELA_NOME,
                    null,
                    values
            );
        }
        finally {
            Close();
        }

        return linhasInseridas;
    }

    public UsuarioModel Select(final String usuario, final String senha){
        return null;
    }
}
