package unesc.uol.precofipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unesc.uol.precofipeapp.activities.ModelosActivity;
import unesc.uol.precofipeapp.adapter.MarcaAdapter;
import unesc.uol.precofipeapp.api.Api;
import unesc.uol.precofipeapp.api.model.Marca;
import unesc.uol.precofipeapp.util.DialogUtil;
import unesc.uol.precofipeapp.util.KeyUtil;

public class MainActivity extends AppCompatActivity {

    private ListView listaMarcas;
    private MarcaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMarcas = findViewById(R.id.listaVeiculos);
        listaMarcas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(MainActivity.this, ModelosActivity.class);
                it.putExtra(KeyUtil.KEY_CODIGO_MARCA, ((Marca)adapter.getItem(position)).getCodigo());
                startActivity(it);
            }
        });

        Toast.makeText(MainActivity.this, "Buscando marcas de veículos...", Toast.LENGTH_LONG).show();

        Api.getMarcas(new Callback<List<Marca>>() {
            @Override
            public void onResponse(Call<List<Marca>> call, Response<List<Marca>> response) {
                if (response.isSuccessful()){
                    adapter = new MarcaAdapter(MainActivity.this, response.body());

                    listaMarcas.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else{
                    DialogUtil.show(MainActivity.this, "ERRO", "Falha ao buscar marcas do veículo.");
                }
            }

            @Override
            public void onFailure(Call<List<Marca>> call, Throwable t) {
                t.printStackTrace();
                DialogUtil.show(MainActivity.this, "ERRO", "Falha ao buscar marcas do veículo.");
            }
        });

    }
}