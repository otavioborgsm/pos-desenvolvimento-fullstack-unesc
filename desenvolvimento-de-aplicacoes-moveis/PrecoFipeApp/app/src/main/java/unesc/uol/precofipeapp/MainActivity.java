package unesc.uol.precofipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listaVeiculos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] dados = new String[]{
                "Corsa",
                "Focus",
                "Tracker",
                "Onix",
                "Etios",
                "Gol",
                "Belina",
                "Corsa",
                "Focus",
                "Tracker",
                "Onix",
                "Etios",
                "Gol",
                "Belina",
                "Corsa",
                "Focus",
                "Tracker",
                "Onix",
                "Etios",
                "Gol",
                "Belina"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                dados
            );

        listaVeiculos = findViewById(R.id.listaVeiculos);
        listaVeiculos.setAdapter(adapter);

    }
}