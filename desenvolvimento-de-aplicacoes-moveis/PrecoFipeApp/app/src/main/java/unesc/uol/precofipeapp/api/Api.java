package unesc.uol.precofipeapp.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import unesc.uol.precofipeapp.api.endpoint.AnoEndpoint;
import unesc.uol.precofipeapp.api.endpoint.MarcaEndpoint;
import unesc.uol.precofipeapp.api.endpoint.ModeloEndpoint;
import unesc.uol.precofipeapp.api.endpoint.ValorEndpoint;
import unesc.uol.precofipeapp.api.model.Ano;
import unesc.uol.precofipeapp.api.model.Marca;
import unesc.uol.precofipeapp.api.model.Modelo;
import unesc.uol.precofipeapp.api.model.Valor;

public class Api {

    public static final String URL_ROOT = "https://parallelum.com.br/fipe/api/v1/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL_ROOT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static void getMarcas(final Callback<List<Marca>> callback){

        MarcaEndpoint endpoint = retrofit.create(MarcaEndpoint.class);

        Call<List<Marca>> call = endpoint.getMarcas();
        call.enqueue(callback);
    }

    public static void getModelos(int codigo, final Callback<Modelo> callback){

        ModeloEndpoint endpoint = retrofit.create(ModeloEndpoint.class);

        Call<Modelo> call = endpoint.getModelos(codigo);
        call.enqueue(callback);
    }

    public static void getAnos(int codigo, int codigo_modelo, final Callback<List<Ano>> callback){

        AnoEndpoint endpoint = retrofit.create(AnoEndpoint.class);

        Call<List<Ano>> call = endpoint.getAnos(codigo, codigo_modelo);
        call.enqueue(callback);
    }

    public static void getValor(int codigo, int codigo_modelo, String codigo_ano ,final Callback<Valor> callback){

        ValorEndpoint endpoint = retrofit.create(ValorEndpoint.class);

        Call<Valor> call = endpoint.getValor(codigo, codigo_modelo, codigo_ano);
        call.enqueue(callback);
    }

}
