package com.example.julolopop.datosxmltema3;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.julolopop.datosxmltema3.pojo.Noticias;
import com.example.julolopop.datosxmltema3.repository.RepositoryNoticias;

import java.util.ArrayList;

public class Eje4Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ListView listView;
    ArrayAdapter<Noticias> adapter;
    ArrayList<Noticias> noticias;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eje4);

        this.listView = (ListView) findViewById(android.R.id.list);
        this.fab = (FloatingActionButton) findViewById(R.id.fab);
        adapter = new ArrayAdapter<Noticias>(this, android.R.layout.simple_list_item_1);
        this.noticias = new ArrayList<>();

        noticias = RepositoryNoticias.newInstance().getNoticias();
        adapter.clear();
        adapter.addAll(noticias);


        this.listView.setAdapter(adapter);
        this.fab.setOnClickListener(this);
        this.listView.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == fab) {

            startActivity(new Intent(Eje4Activity.this,InicializarNoticiasActivity.class));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(Eje4Activity.this, RssActivity.class);

        intent.putExtra("URI",noticias.get(position).getWeb());

        startActivity(intent);
    }
}
