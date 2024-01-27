package unesc.uol.precofipeapp.api.endpoint;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import unesc.uol.precofipeapp.api.model.Ano;

public interface AnoEndpoint {

    @GET("carros/marcas/{codigo}/modelos/{codigo_modelo}/anos")
    Call<List<Ano>> getAnos(@Path("codigo") int codigo, @Path("codigo_modelo") int codigo_modelo);
}
