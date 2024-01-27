package unesc.uol.precofipeapp.api.endpoint;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import unesc.uol.precofipeapp.api.model.Marca;
import unesc.uol.precofipeapp.api.model.Modelo;

public interface ModeloEndpoint {

    @GET("carros/marcas/{codigo}/modelos")
    Call<Modelo> getModelos(@Path("codigo") int codigo);
}
