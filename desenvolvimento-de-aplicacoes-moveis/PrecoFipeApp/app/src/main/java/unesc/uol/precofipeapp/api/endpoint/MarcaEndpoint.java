package unesc.uol.precofipeapp.api.endpoint;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import unesc.uol.precofipeapp.api.model.Marca;

public interface MarcaEndpoint {

    @GET("carros/marcas")
    Call<List<Marca>> getMarcas();
}
