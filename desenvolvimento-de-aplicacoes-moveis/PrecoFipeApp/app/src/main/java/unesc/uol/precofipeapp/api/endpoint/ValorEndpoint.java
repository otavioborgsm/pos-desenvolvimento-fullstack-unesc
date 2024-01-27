package unesc.uol.precofipeapp.api.endpoint;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import unesc.uol.precofipeapp.api.model.Ano;
import unesc.uol.precofipeapp.api.model.Valor;

public interface ValorEndpoint {

    @GET("carros/marcas/{codigo}/modelos/{codigo_modelo}/anos/{codigo_ano}")
    Call<Valor> getValor(@Path("codigo") int codigo,
                         @Path("codigo_modelo") int codigo_modelo,
                         @Path("codigo_ano") String codigo_ano);
}
