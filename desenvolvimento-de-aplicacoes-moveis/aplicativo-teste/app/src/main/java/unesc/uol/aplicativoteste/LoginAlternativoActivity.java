package unesc.uol.aplicativoteste;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import unesc.uol.aplicativoteste.util.KeyUtil;

public class LoginAlternativoActivity extends AppCompatActivity {

    private TextInputLayout inputEmail;
    private TextInputLayout inputSenha;
    private Button btnEntrar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_alternativo);


        inputEmail = findViewById(R.id.inputEmail);
        inputSenha = findViewById(R.id.inputSenha);
        btnEntrar = findViewById(R.id.btnEntrar);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String conteudoEmail = inputEmail.getEditText().getText().toString();
                String conteudoSenha = inputSenha.getEditText().getText().toString();

                inputEmail.setErrorEnabled(false);
                inputSenha.setErrorEnabled(false);

                if (conteudoEmail.isEmpty()){
                    inputEmail.setError("Campo e-mail é obrigatório");
                    inputEmail.setErrorEnabled(true);
                } else if (conteudoSenha.isEmpty()) {
                    inputSenha.setError("Campo senha é obrigatório");
                    inputSenha.setErrorEnabled(true);
                } else {
                    Toast.makeText(LoginAlternativoActivity.this, "CAMPOS PREENCHIDOS", Toast.LENGTH_LONG).show();

                    Intent it = new Intent(LoginAlternativoActivity.this, PrincipalActivity.class);
                    it.putExtra(KeyUtil.KEY_EMAIL, conteudoEmail);

                    startActivity(it);
                }

            }
        });
    }
}
