package com.example.arqdsis.prova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by heitor on 05/05/2017.
 * Via intent faz a listagem dos paises do continente selecionado
 */
public class ListarPaisesActivity {

    ListView listView;
    Paises[] lista;
    public static final String PAISES = "com.example.arqdsis.prova";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_clientes);
        listView = (ListView) findViewById(R.id.lista_de_paises);
        Intent intent = getIntent();
        ArrayList<Paises> clientes = (ArrayList<Paises>) intent.getSerializableExtra(MainActivity.LISTA);
        lista = clientes.toArray(new Paises[0]);
        BaseAdapter adapter = new PaisesAdapter(this, lista);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {
                Intent intent1 = new Intent(ListarPaisesActivity.this, DetallhePaisesActivity.class);
                intent1.putExtra(CLIENTE, lista[posicao]);
                startActivity(intent1);

            }
        });
    }

}
