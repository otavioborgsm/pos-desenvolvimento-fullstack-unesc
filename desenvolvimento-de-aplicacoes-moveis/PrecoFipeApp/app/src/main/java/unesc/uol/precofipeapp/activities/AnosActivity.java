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
import unesc.uol.precofipeapp.api.model.Valor;
import unesc.uol.precofipeapp.util.DialogUtil;
import unesc.uol.precofipeapp.util.KeyUtil;

public class AnosActivity extends AppCompatActivity {

    private ListView anos;
    private int codigo_marca;
    private int codigo_modelo;
    private String codigo_ano;
    private AnoAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anos);

        anos = findViewById(R.id.listaAnos);
        anos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                codigo_ano = ((Ano)adapter.getItem(position)).getCodigo();

                Api.getValor(codigo_marca, codigo_modelo, codigo_ano, new Callback<Valor>() {
                    @Override
                    public void onResponse(Call<Valor> call, Response<Valor> response) {
                        if (response.isSuccessful()){
                            DialogUtil.show(AnosActivity.this, "FIPE", "O valor da FIPE é: " + response.body().getValor());
                        } else{
                            DialogUtil.show(AnosActivity.this, "ERRO", "Falha ao buscar os anos do veículo.");
                        }
                    }

                    @Override
                    public void onFailure(Call<Valor> call, Throwable t) {
                        DialogUtil.show(AnosActivity.this, "ERRO", "Falha ao buscar os anos do veículo.");
                    }
                });
            }
        });

        Toast.makeText(AnosActivity.this, "Buscando os anos do veículo...", Toast.LENGTH_LONG).show();

        codigo_marca = getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MARCA, 0);
        codigo_modelo = getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MODELO, 0);
        Api.getAnos(codigo_marca, codigo_modelo, new Callback<List<Ano>>() {
            @Override
            public void onResponse(Call<List<Ano>> call, Response<List<Ano>> response) {
                if (response.isSuccessful()){
                    adapter = new AnoAdapter(AnosActivity.this, response.body());

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
