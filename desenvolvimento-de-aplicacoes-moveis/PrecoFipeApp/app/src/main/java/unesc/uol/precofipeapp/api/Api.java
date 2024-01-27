package unesc.uol.precofipeapp.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import unesc.uol.precofipeapp.api.endpoint.MarcaEndpoint;
import unesc.uol.precofipeapp.api.endpoint.ModeloEndpoint;
import unesc.uol.precofipeapp.api.model.Marca;
import unesc.uol.precofipeapp.api.model.Modelo;

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

}
