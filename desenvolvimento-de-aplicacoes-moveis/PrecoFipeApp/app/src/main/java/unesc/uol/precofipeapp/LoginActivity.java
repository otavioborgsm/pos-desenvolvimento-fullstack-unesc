package unesc.uol.precofipeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editSenha;
    private Button btnEntrar;
    private HashMap<String, String> hmpUsuario = new HashMap<String, String>();


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
                            Intent it = new Intent(LoginActivity.this, MainActivity.class);

                            startActivity(it);
                        } else {
                            Toast.makeText(LoginActivity.this, "Senha inválida!", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(LoginActivity.this, "Usuário inexistente!", Toast.LENGTH_LONG).show();
                    }

                }

            }
        });
    }
}
