package com.example.paulosergio.busquecep;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Main2Activity extends ListActivity{
    public EditText editnome;
    public String nome;
    public String cep;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent it = getIntent();
        nome = it.getStringExtra("nomekey");
        cep = it.getStringExtra("cepkey");

        String[] item = new String[]{nome};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, item);
        setListAdapter(arrayAdapter);

    }



    protected void onListItemClick(ListView list, View view, int posicao, long id) {

        super.onListItemClick(list, view, posicao, id);
        switch (posicao) {

            case 0:
                Intent it = new Intent(this, Main3Activity.class); //Indo para a MainActivity.
                it.putExtra("nomekeyview", nome);
                it.putExtra("cepkeyview", cep);

                startActivity(it);
                Toast.makeText(getApplicationContext(), "Tela consulta !!!", Toast.LENGTH_LONG).show();

        }

    }


}
