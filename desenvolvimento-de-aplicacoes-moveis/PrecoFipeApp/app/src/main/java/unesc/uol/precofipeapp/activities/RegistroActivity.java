package unesc.uol.precofipeapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import unesc.uol.precofipeapp.R;
import unesc.uol.precofipeapp.util.KeyUtil;

public class RegistroActivity extends AppCompatActivity {

    private Button btnSalvar;
    private Button btnCancelar;
    private EditText editNomeUsuario;
    private EditText editEmailUsuario;
    private EditText editSenhaUsuario;
    private EditText editConfirmarSenha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adtivity_registro);

        editSenhaUsuario = findViewById(R.id.editSenhaUsuario);
        editConfirmarSenha = findViewById(R.id.editConfirmarSenha);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editNomeUsuario.getText().toString().isEmpty()){
                    editNomeUsuario.setError("Campo nome obrigatório!");
                    editNomeUsuario.setEnabled(true);
                } else if (editEmailUsuario.getText().toString().isEmpty()) {
                    editEmailUsuario.setError("Campo E-mail obrigatório!");
                    editEmailUsuario.setEnabled(true);
                } else if (!editSenhaUsuario.getText().toString().equals(editConfirmarSenha.getText().toString())){
                    editSenhaUsuario.setText("");
                    editConfirmarSenha.setText("");
                    Toast.makeText(RegistroActivity.this, "Senhas diferentes!", Toast.LENGTH_LONG);
                } else {
                    Intent it = new Intent();
                    it.putExtra(KeyUtil.KEY_REGISTRO_NOME_USUARIO, editNomeUsuario.getText().toString());
                    it.putExtra(KeyUtil.KEY_REGISTRO_EMAIL_USUARIO, editEmailUsuario.getText().toString());
                    it.putExtra(KeyUtil.KEY_REGISTRO_SENHA_USUARIO, editSenhaUsuario.getText().toString());

                    setResult(1, it);
                    finish();
                }

            }
        });


        btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(9);
                finish();
            }
        });

        editNomeUsuario = findViewById(R.id.editNomeUsuario);
        editEmailUsuario = findViewById(R.id.editEmailUsuario);

    }
}
