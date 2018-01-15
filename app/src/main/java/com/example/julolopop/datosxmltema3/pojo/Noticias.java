package com.example.julolopop.datosxmltema3.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Julolopop on 15/01/2018.
 */

public class Noticias implements Parcelable {
    String nombre;
    String web;

    protected Noticias(Parcel in) {
        nombre = in.readString();
        web = in.readString();
    }

    @Override
    public String toString() {
        return  nombre ;
    }

    public static final Creator<Noticias> CREATOR = new Creator<Noticias>() {
        @Override
        public Noticias createFromParcel(Parcel in) {
            return new Noticias(in);
        }

        @Override
        public Noticias[] newArray(int size) {
            return new Noticias[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(web);
    }

    public Noticias(String nombre, String web) {
        this.nombre = nombre;
        this.web = web;
    }

    public String getNombre() {
        return nombre;
    }

    public String getWeb() {
        return web;
    }
}
