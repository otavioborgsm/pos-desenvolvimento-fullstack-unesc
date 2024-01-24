package unesc.uol.precofipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import unesc.uol.precofipeapp.adapter.VeiculoAdapter;
import unesc.uol.precofipeapp.model.Veiculo;

public class MainActivity extends AppCompatActivity {

    private ListView listaVeiculos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Veiculo> arl = new ArrayList<Veiculo>();
        arl.add(new Veiculo("Corsa", 2006));
        arl.add(new Veiculo("Focus", 2010));
        arl.add(new Veiculo("Tracker", 2023));
        arl.add(new Veiculo("Etios", 2015));
        arl.add(new Veiculo("Onix", 2016));
        arl.add(new Veiculo("Ferrari", 2022));
        arl.add(new Veiculo("Belina", 1980));
        arl.add(new Veiculo("Pulse", 2024));
        arl.add(new Veiculo("Argo", 2018));
        arl.add(new Veiculo("Ka", 2018));
        arl.add(new Veiculo("Renegade", 2016));
        arl.add(new Veiculo("Compass", 2019));
        arl.add(new Veiculo("Golf", 2017));
        arl.add(new Veiculo("March", 2015));
        arl.add(new Veiculo("Fit", 2014));
        arl.add(new Veiculo("hb20", 2016));

        listaVeiculos = findViewById(R.id.listaVeiculos);
        listaVeiculos.setAdapter(new VeiculoAdapter(MainActivity.this, arl));

    }
}