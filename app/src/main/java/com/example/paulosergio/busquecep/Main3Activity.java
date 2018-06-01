package com.example.paulosergio.busquecep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paulosergio.busquecep.models.Cliente;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Path;

public class Main3Activity extends AppCompatActivity {
    public String nome;
    public String cep;
    private TextView tvnome;
    private TextView tvcep;
    private TextView tvlogradouro;
    private TextView tvcomplemento;
    private TextView tvbairro;
    private TextView tvlocalidade;
    private TextView tvuf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);
        Intent it = getIntent();
        nome = it.getStringExtra("nomekeyview");
        cep = it.getStringExtra("cepkeyview");
        tvcep = findViewById(R.id.tv_cep);
        tvnome = findViewById(R.id.tv_nome);
        tvlogradouro = findViewById(R.id.tv_logradouro);
        tvcomplemento = findViewById(R.id.tv_complemento);
        tvbairro = findViewById(R.id.tv_bairro);
        tvlocalidade = findViewById(R.id.tv_localidade);
        tvuf = findViewById(R.id.tv_uf);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        CepService service  = retrofit.create(CepService.class);
        Call<Cliente> cepService = service.listCliente(cep);

        cepService.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Erro na Resposta do Serviço" + response.code(), Toast.LENGTH_LONG).show();
                }else{
                    Cliente c = response.body();

                    tvnome.setText(nome);
                    tvcep.setText(c.getCep());
                    tvlogradouro.setText(c.getLogradouro());
                    tvbairro.setText(c.getBairro());
                    tvlocalidade.setText(c.getLocalidade());
                    tvuf.setText(c.getUf());
                }

            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Log.i("ERROTAG", "Erro na conexão" + t.getMessage());
            }
        });

    }
}
