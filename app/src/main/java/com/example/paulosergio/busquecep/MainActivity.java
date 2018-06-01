package com.example.paulosergio.busquecep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public EditText nome;
    public EditText cep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void salvar(View view) {

        nome = findViewById(R.id.editNome);
        cep = findViewById(R.id.editCep);

        Intent it = new Intent(this, Main2Activity.class); //Indo para a MainActivity.
        it.putExtra("nomekey",nome.getText().toString());
        it.putExtra("cepkey", cep.getText().toString());

        startActivity(it);


    }
}
