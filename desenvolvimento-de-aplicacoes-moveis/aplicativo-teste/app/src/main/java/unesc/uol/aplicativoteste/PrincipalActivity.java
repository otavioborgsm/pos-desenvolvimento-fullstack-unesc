package unesc.uol.aplicativoteste;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import unesc.uol.aplicativoteste.util.KeyUtil;

public class PrincipalActivity extends AppCompatActivity {

    private TextView textEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        String email = getIntent().getStringExtra(KeyUtil.KEY_EMAIL);

        textEmail = findViewById(R.id.textEmail);
        textEmail.setText(email);


    }
}
