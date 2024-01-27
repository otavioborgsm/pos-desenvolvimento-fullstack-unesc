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
import unesc.uol.precofipeapp.adapter.AnoAdapter;
import unesc.uol.precofipeapp.adapter.ModeloAdapter;
import unesc.uol.precofipeapp.api.Api;
import unesc.uol.precofipeapp.api.model.Ano;
import unesc.uol.precofipeapp.api.model.Modelo;
import unesc.uol.precofipeapp.util.DialogUtil;
import unesc.uol.precofipeapp.util.KeyUtil;

public class AnosActivity extends AppCompatActivity {

    private ListView anos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anos);

        anos = findViewById(R.id.listaAnos);
        anos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

        Toast.makeText(AnosActivity.this, "Buscando os anos do veículo...", Toast.LENGTH_LONG).show();

        int codigoMarca = getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MARCA, 0);
        int codigoModelo = getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MODELO, 0);
        Api.getAnos(codigoMarca, codigoModelo, new Callback<List<Ano>>() {
            @Override
            public void onResponse(Call<List<Ano>> call, Response<List<Ano>> response) {
                if (response.isSuccessful()){
                    AnoAdapter adapter = new AnoAdapter(AnosActivity.this, response.body());

                    anos.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else{
                    DialogUtil.show(AnosActivity.this, "ERRO", "Falha ao buscar os anos do veículo.");
                }
            }

            @Override
            public void onFailure(Call<List<Ano>> call, Throwable t) {
                t.printStackTrace();
                DialogUtil.show(AnosActivity.this, "ERRO", "Falha ao buscar os anos do veículo.");

            }
        });
    }
}
