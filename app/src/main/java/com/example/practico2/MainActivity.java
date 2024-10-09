package com.example.practico2;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import com.example.practico2.api.ApiService;
import com.example.practico2.api.RetrofitClient;
import com.example.practico2.model.Usuario;
import com.example.practico2.adapter.UsuarioAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UsuarioAdapter usuarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializa el layout
        setContentView(R.layout.activity_main);

        // Configura RecyclerView
        recyclerView = findViewById(R.id.recyclerViewUsuarios);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializa el adaptador con una lista vacía
        usuarioAdapter = new UsuarioAdapter(new ArrayList<>());
        recyclerView.setAdapter(usuarioAdapter);

        // Obtiene usuarios desde la API
        obtenerUsuarios();
    }

    private void obtenerUsuarios() {
        ApiService apiService = RetrofitClient.getApiService();
        Call<List<Usuario>> call = apiService.obtenerUsuarios();
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Usuario> usuarios = response.body();
                    Log.d("MainActivity", "Usuarios recibidos: " + usuarios.size());
                    // Actualiza el adaptador con los nuevos usuarios
                    usuarioAdapter.updateUsuarios(usuarios);
                } else {
                    Log.e("MainActivity", "Error en la respuesta: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.e("MainActivity", "Error al obtener usuarios: " + t.getMessage());
            }
        });
    }
}
