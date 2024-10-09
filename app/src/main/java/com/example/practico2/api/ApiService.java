package com.example.practico2.api;

import com.example.practico2.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("usuario/agregar-usuario")
    Call<Void> agregarUsuario(@Body Usuario usuario);

    @GET("practico1-web/rest/usuario/obtener-usuarios") // Cambia esto al endpoint correcto
    Call<List<Usuario>> obtenerUsuarios();


}
