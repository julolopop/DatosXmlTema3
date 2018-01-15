package com.example.julolopop.datosxmltema3.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Julolopop on 15/01/2018.
 */

public class Rss implements Parcelable {

    String titulo;
    String descripcion;
    String link;

    public Rss() {
    }

    @Override
    public String toString() {
        return "titulo=" + titulo + '\n' +
                ", descripcion='" + descripcion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLink(String link) {
        this.link = link;
    }

    protected Rss(Parcel in) {
        titulo = in.readString();
        descripcion = in.readString();
        link = in.readString();
    }

    public static final Creator<Rss> CREATOR = new Creator<Rss>() {
        @Override
        public Rss createFromParcel(Parcel in) {
            return new Rss(in);
        }

        @Override
        public Rss[] newArray(int size) {
            return new Rss[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLink() {
        return link;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(descripcion);
        dest.writeString(link);
    }
}
