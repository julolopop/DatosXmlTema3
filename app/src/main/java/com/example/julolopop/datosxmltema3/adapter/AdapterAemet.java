package com.example.julolopop.datosxmltema3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.julolopop.datosxmltema3.Eje2Activity;
import com.example.julolopop.datosxmltema3.R;
import com.example.julolopop.datosxmltema3.pojo.Aemet;

import java.util.ArrayList;

/**
 * Created by Julolopop on 03/01/2018.
 */

public class AdapterAemet extends ArrayAdapter<Aemet>{
    public AdapterAemet(@NonNull Context context) {
        super(context, R.layout.item_aemet,new ArrayList<Aemet>());
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AemetHorler horler;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_aemet,null);
            horler = new AemetHorler();

            horler.fecha = (TextView)convertView.findViewById(R.id.txv_Fecha);

            horler.lluvia1 = (TextView)convertView.findViewById(R.id.txv_Precipitacion1);
            horler.lluvia2 = (TextView)convertView.findViewById(R.id.txv_Precipitacion2);
            horler.lluvia3 = (TextView)convertView.findViewById(R.id.txv_Precipitacion3);
            horler.lluvia4 = (TextView)convertView.findViewById(R.id.txv_Precipitacion4);


            horler.nieve1 = (TextView)convertView.findViewById(R.id.txv_Nieve1);
            horler.nieve2 = (TextView)convertView.findViewById(R.id.txv_Nieve2);
            horler.nieve3 = (TextView)convertView.findViewById(R.id.txv_Nieve3);
            horler.nieve4 = (TextView)convertView.findViewById(R.id.txv_Nieve4);

            horler.stado1 = (TextView)convertView.findViewById(R.id.txv_estado1);
            horler.stado2 = (TextView)convertView.findViewById(R.id.txv_estado2);
            horler.stado3 = (TextView)convertView.findViewById(R.id.txv_estado3);
            horler.stado4 = (TextView)convertView.findViewById(R.id.txv_estado4);

            horler.direccion1 = (TextView)convertView.findViewById(R.id.txv_direccion1);
            horler.direccion2 = (TextView)convertView.findViewById(R.id.txv_direccion2);
            horler.direccion3 = (TextView)convertView.findViewById(R.id.txv_direccion3);
            horler.direccion4 = (TextView)convertView.findViewById(R.id.txv_direccion4);

            horler.velocidad1 = (TextView)convertView.findViewById(R.id.txv_velocidad1);
            horler.velocidad2 = (TextView)convertView.findViewById(R.id.txv_velocidad2);
            horler.velocidad3 = (TextView)convertView.findViewById(R.id.txv_velocidad3);
            horler.velocidad4 = (TextView)convertView.findViewById(R.id.txv_velocidad4);

            horler.temperatura1 = (TextView)convertView.findViewById(R.id.txv_temperatura1);
            horler.temperatura2 = (TextView)convertView.findViewById(R.id.txv_temperatura2);
            horler.temperatura3 = (TextView)convertView.findViewById(R.id.txv_temperatura3);
            horler.temperatura4 = (TextView)convertView.findViewById(R.id.txv_temperatura4);

            horler.humedad1 = (TextView)convertView.findViewById(R.id.txv_humedad1);
            horler.humedad2 = (TextView)convertView.findViewById(R.id.txv_humedad2);
            horler.humedad3 = (TextView)convertView.findViewById(R.id.txv_humedad3);
            horler.humedad4 = (TextView)convertView.findViewById(R.id.txv_humedad4);

            convertView.setTag(horler);
        }else{
            horler = (AemetHorler) convertView.getTag();
        }




        horler.fecha.setText((CharSequence) getItem(position).getFecha());

        horler.lluvia1.setText((getItem(position).getLluvia1()));
        horler.lluvia2.setText((getItem(position).getLluvia2()));
        horler.lluvia3.setText((getItem(position).getLluvia3()));
        horler.lluvia4.setText((getItem(position).getLluvia4()));


        horler.nieve1.setText((getItem(position).getNieve1()));
        horler.nieve2.setText((getItem(position).getNieve2()));
        horler.nieve3.setText((getItem(position).getNieve3()));
        horler.nieve4.setText((getItem(position).getNieve4()));

        horler.stado1.setText((getItem(position).getStado1()));
        horler.stado2.setText((getItem(position).getStado2()));
        horler.stado3.setText((getItem(position).getStado3()));
        horler.stado4.setText((getItem(position).getStado4()));

        horler.direccion1.setText((getItem(position).getDireccion1()));
        horler.direccion2.setText((getItem(position).getDireccion2()));
        horler.direccion3.setText((getItem(position).getDireccion3()));
        horler.direccion4.setText((getItem(position).getDireccion4()));

        horler.velocidad1.setText((getItem(position).getVelocidad1()));
        horler.velocidad2.setText((getItem(position).getVelocidad2()));
        horler.velocidad3.setText((getItem(position).getVelocidad3()));
        horler.velocidad4.setText((getItem(position).getVelocidad4()));

        horler.temperatura1.setText((getItem(position).getTemperatura1()));
        horler.temperatura2.setText((getItem(position).getTemperatura2()));
        horler.temperatura3.setText((getItem(position).getTemperatura3()));
        horler.temperatura4.setText((getItem(position).getTemperatura4()));

        horler.humedad1.setText((getItem(position).getHumedad1()));
        horler.humedad2.setText((getItem(position).getHumedad2()));
        horler.humedad3.setText((getItem(position).getHumedad3()));
        horler.humedad4.setText((getItem(position).getHumedad4()));



        return convertView;
    }


    class AemetHorler{
        TextView fecha;

        TextView lluvia1;
        TextView lluvia2;
        TextView lluvia3;
        TextView lluvia4;

        TextView nieve1;
        TextView nieve2;
        TextView nieve3;
        TextView nieve4;

        TextView stado1;
        TextView stado2;
        TextView stado3;
        TextView stado4;

        TextView direccion1;
        TextView direccion2;
        TextView direccion3;
        TextView direccion4;

        TextView velocidad1;
        TextView velocidad2;
        TextView velocidad3;
        TextView velocidad4;

        TextView temperatura1;
        TextView temperatura2;
        TextView temperatura3;
        TextView temperatura4;

        TextView humedad1;
        TextView humedad2;
        TextView humedad3;
        TextView humedad4;

    }
}
