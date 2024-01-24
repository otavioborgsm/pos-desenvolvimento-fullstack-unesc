package unesc.uol.precofipeapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import unesc.uol.precofipeapp.MainActivity;
import unesc.uol.precofipeapp.R;
import unesc.uol.precofipeapp.util.DialogUtil;
import unesc.uol.precofipeapp.util.KeyUtil;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editSenha;
    private Button btnEntrar;
    private Button btnRegistrar;
    private Switch switchLembrarSenha;
    private HashMap<String, String> hmpUsuario = new HashMap<String, String>();
    private static final int REQUISICAO_REGISTRO = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        hmpUsuario.put("teste", "teste");
        hmpUsuario.put("otavio.mb@gmail.com", "123456");
        hmpUsuario.put("administrador@gmail.com", "administrador");

        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);

        btnEntrar = findViewById(R.id.btnEntrar);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        switchLembrarSenha = findViewById(R.id.switchLembrarSenha);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivityForResult(it, REQUISICAO_REGISTRO);
            }
        });
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String conteudoEmail = editEmail.getText().toString();
                String conteudoSenha = editSenha.getText().toString();

                if (conteudoEmail.isEmpty()){
                    editEmail.setError("Campo e-mail é obrigatório");
                } else if (conteudoSenha.isEmpty()) {
                    editSenha.setError("Campo senha é obrigatório");
                } else {

                    if (hmpUsuario.containsKey(conteudoEmail)){
                        final String senhaBanco = hmpUsuario.get(conteudoEmail);
                        if (senhaBanco.equals(conteudoSenha)){

                            if (switchLembrarSenha.isChecked()){
                                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                                SharedPreferences.Editor editor = preferences.edit();

                                editor.putString(KeyUtil.KEY_USUARIO, conteudoEmail)
                                        .putString(KeyUtil.KEY_SENHA, conteudoSenha).apply();
                            }

                            Intent it = new Intent(LoginActivity.this, MainActivity.class);

                            startActivity(it);
                        } else {
                            DialogUtil.showError(LoginActivity.this, "ERRO", "Senha inválida!");
                            Toast.makeText(LoginActivity.this, "Senha inválida!", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        DialogUtil.showError(LoginActivity.this, "ERRO", "Usuário inexistente!");
                        Toast.makeText(LoginActivity.this, "Usuário inexistente!", Toast.LENGTH_LONG).show();
                    }

                }

            }
        });

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        editEmail.setText(preferences.getString(KeyUtil.KEY_USUARIO, ""));
        editSenha.setText(preferences.getString(KeyUtil.KEY_SENHA, ""));

        if (!editEmail.getText().toString().isEmpty()){
            switchLembrarSenha.setChecked(true);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUISICAO_REGISTRO){
            if (resultCode == 1){

                final String resultadoEmailUsuario = data.getStringExtra(KeyUtil.KEY_REGISTRO_EMAIL_USUARIO);
                editEmail.setText(resultadoEmailUsuario);

                final String resultadoSenhaUsuario = data.getStringExtra(KeyUtil.KEY_REGISTRO_SENHA_USUARIO);
                editSenha.setText(resultadoSenhaUsuario);

            } else if (resultCode == 9) {
                Toast.makeText(LoginActivity.this, "Cancelou o registro de usuário!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
