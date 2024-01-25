package unesc.uol.precofipeapp.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

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


    public long Delete(final String email){

        long linhasDeletadas = 0;

        try {
            Open();
            linhasDeletadas = db.delete(
                    UsuarioModel.TABELA_NOME,
                    UsuarioModel.COLUNA_EMAIL_USUARIO +" = ? ",
                    new String[]{email}
            );

        } finally {
            Close();
        }


        return linhasDeletadas;
    }

    public long Update(final String email, final String senha){
        long linhasAlteradas = 0;

        ContentValues values = new ContentValues();
        values.put(UsuarioModel.COLUNA_SENHA_USUARIO, senha);
        try {
            Open();

            linhasAlteradas = db.update(
                    UsuarioModel.TABELA_NOME,
                    values,
                    UsuarioModel.COLUNA_EMAIL_USUARIO + " = ? ",
                    new String[]{email}
            );

        } finally {
            Close();
        }

        return linhasAlteradas;
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

    public boolean Select(final String email, final String senha){
        boolean isUsuarioPresente = false;

        try {
            Open();

            Cursor cursor = db.query(
                    UsuarioModel.TABELA_NOME,
                    colunas,
                    UsuarioModel.COLUNA_EMAIL_USUARIO + " = ? and " + UsuarioModel.COLUNA_SENHA_USUARIO +" = ?",
                    new String[]{email, senha},
                    null,
                    null,
                    null
            );

            if (cursor != null){
                isUsuarioPresente = cursor.moveToFirst();
            }

        }
        finally {
            Close();
        }


        return isUsuarioPresente;
    }
}
