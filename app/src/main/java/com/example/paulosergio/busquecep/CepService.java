package com.example.paulosergio.busquecep;

import com.example.paulosergio.busquecep.models.Cliente;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepService {


  @GET("ws/{cep}/json")
  Call<Cliente> listCliente(@Path("cep") String cep);


}
