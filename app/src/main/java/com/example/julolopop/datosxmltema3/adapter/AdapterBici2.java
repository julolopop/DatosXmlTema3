package com.example.julolopop.datosxmltema3.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.julolopop.datosxmltema3.R;
import com.example.julolopop.datosxmltema3.pojo.Bici;

import java.util.ArrayList;

/**
 * Created by Julolopop on 04/01/2018.
 */

public class AdapterBici2 extends ArrayAdapter<Bici> {

    public AdapterBici2(@NonNull Context context) {
        super(context, R.layout.item_bici2,new ArrayList<Bici>());
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        BiciHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_bici2,null);
            holder = new BiciHolder();

            holder.titulo = (TextView)convertView.findViewById(R.id.txv_Nombre);
            holder.estado = (TextView)convertView.findViewById(R.id.txv_Estado);
            holder.bicis = (TextView)convertView.findViewById(R.id.txv_Bicisd);
            holder.anclajes = (TextView)convertView.findViewById(R.id.txv_Anclajes);
            holder.web = (WebView)convertView.findViewById(R.id.webView);
            holder.boton = (Button)convertView.findViewById(R.id.btn_web);

            convertView.setTag(holder);
        }else {
            holder = (BiciHolder) convertView.getTag();
        }

        holder.titulo.setText(getItem(position).getTitulo());
        holder.estado.setText(getItem(position).getEstado());
        holder.bicis.setText(getItem(position).getBicisDisponibles());
        holder.anclajes.setText(getItem(position).getAnclajesDisponibles());

        holder.web.setWebViewClient(new WebViewClient());
        holder.web.getSettings().setJavaScriptEnabled(true);
        holder.web.getSettings().setBuiltInZoomControls(true);
        String coordenadas = getItem(position).getCordenadas().substring(getItem(position).getCordenadas().indexOf(',')+1,getItem(position).getCordenadas().length());
        coordenadas += ","+getItem(position).getCordenadas().substring(0,getItem(position).getCordenadas().indexOf(',')-1);
        holder.web.loadUrl("https://www.google.es/maps/place/"+coordenadas);

        holder.boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(getItem(position).getAbout());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                getContext().startActivity(intent);

            }
        });


        return convertView;
    }

    class BiciHolder{
        TextView titulo;
        TextView estado;
        TextView bicis;
        TextView anclajes;
        WebView web;
        Button boton;

    }
}
