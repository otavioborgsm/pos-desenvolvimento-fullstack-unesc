package unesc.uol.aplicativoteste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import unesc.uol.aplicativoteste.util.KeyUtil;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editSenha;
    private Button btnEntrar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                    Toast.makeText(LoginActivity.this, "CAMPOS PREENCHIDOS", Toast.LENGTH_LONG).show();

                    Intent it = new Intent(LoginActivity.this, PrincipalActivity.class);
                    it.putExtra(KeyUtil.KEY_EMAIL, conteudoEmail);

                    startActivity(it);
                }

            }
        });
    }
}
