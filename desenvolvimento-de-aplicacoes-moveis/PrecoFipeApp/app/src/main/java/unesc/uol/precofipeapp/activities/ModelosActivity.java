package unesc.uol.precofipeapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unesc.uol.precofipeapp.R;
import unesc.uol.precofipeapp.adapter.ModeloAdapter;
import unesc.uol.precofipeapp.api.Api;
import unesc.uol.precofipeapp.api.model.Modelo;
import unesc.uol.precofipeapp.util.DialogUtil;
import unesc.uol.precofipeapp.util.KeyUtil;

public class ModelosActivity extends AppCompatActivity {

    private ListView modelos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modelos);

        modelos = findViewById(R.id.listaModelos);
        modelos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

        Toast.makeText(ModelosActivity.this, "Buscando Modelos de veículos...", Toast.LENGTH_LONG).show();

        Api.getModelos(getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MARCA, 0), new Callback<Modelo>() {
            @Override
            public void onResponse(Call<Modelo> call, Response<Modelo> response) {
                if (response.isSuccessful()){
                    ModeloAdapter adapter = new ModeloAdapter(ModelosActivity.this, response.body().getModelos());

                    modelos.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else{
                    DialogUtil.show(ModelosActivity.this, "ERRO", "Falha ao buscar marcas do veículo.");
                }
            }

            @Override
            public void onFailure(Call<Modelo> call, Throwable t) {
                t.printStackTrace();
                DialogUtil.show(ModelosActivity.this, "ERRO", "Falha ao buscar marcas do veículo.");

            }
        });
    }
}
