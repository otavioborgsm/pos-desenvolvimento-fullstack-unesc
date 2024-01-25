package unesc.uol.precofipeapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import unesc.uol.precofipeapp.database.model.UsuarioModel;

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NOME = "precofipe.db";
    private static final int DATABASE_VERSION = 1;

    public DBOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioModel.CRATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UsuarioModel.DROP_TABLE);
        db.execSQL(UsuarioModel.CRATE_TABLE);
    }
}
