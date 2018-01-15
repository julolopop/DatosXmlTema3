package com.example.julolopop.datosxmltema3.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Julolopop on 04/01/2018.
 */

public class Bici implements Parcelable {

    String id;
    String About;
    String titulo;
    String estado;
    String bicisDisponibles;
    String anclajesDisponibles;
    String cordenadas;

    public Bici(Parcel in) {
        id = in.readString();
        About = in.readString();
        titulo = in.readString();
        estado = in.readString();
        bicisDisponibles = in.readString();
        anclajesDisponibles = in.readString();
        cordenadas = in.readString();
    }

    public static final Creator<Bici> CREATOR = new Creator<Bici>() {
        @Override
        public Bici createFromParcel(Parcel in) {
            return new Bici(in);
        }

        @Override
        public Bici[] newArray(int size) {
            return new Bici[size];
        }
    };

    public Bici() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBicisDisponibles() {
        return bicisDisponibles;
    }

    public void setBicisDisponibles(String bicisDisponibles) {
        this.bicisDisponibles = bicisDisponibles;
    }

    public String getAnclajesDisponibles() {
        return anclajesDisponibles;
    }

    public void setAnclajesDisponibles(String anclajesDisponibles) {
        this.anclajesDisponibles = anclajesDisponibles;
    }

    public String getCordenadas() {
        return cordenadas;
    }

    public void setCordenadas(String cordenadas) {
        this.cordenadas = cordenadas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(About);
        dest.writeString(titulo);
        dest.writeString(estado);
        dest.writeString(bicisDisponibles);
        dest.writeString(anclajesDisponibles);
        dest.writeString(cordenadas);
    }
}
