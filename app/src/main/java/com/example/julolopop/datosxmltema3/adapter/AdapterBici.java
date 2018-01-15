package com.example.julolopop.datosxmltema3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.julolopop.datosxmltema3.R;
import com.example.julolopop.datosxmltema3.pojo.Bici;

import java.util.ArrayList;

/**
 * Created by Julolopop on 04/01/2018.
 */

public class AdapterBici extends ArrayAdapter<Bici> {

    public AdapterBici(@NonNull Context context) {
        super(context, R.layout.item_bici,new ArrayList<Bici>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        BiciHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_bici,null);
            holder = new BiciHolder();

            holder.titulo = (TextView)convertView.findViewById(R.id.txvb_Nombre);
            holder.estado = (TextView)convertView.findViewById(R.id.txvb_estado);

            convertView.setTag(holder);
        }else {
            holder = (BiciHolder) convertView.getTag();
        }

        holder.titulo.setText(getItem(position).getTitulo());
        holder.estado.setText(getItem(position).getEstado());

        return convertView;
    }

    class BiciHolder{
        TextView titulo;
        TextView estado;
    }
}
