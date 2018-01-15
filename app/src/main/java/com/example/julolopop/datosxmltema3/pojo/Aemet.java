package com.example.julolopop.datosxmltema3.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Julolopop on 03/01/2018.
 */

public class Aemet implements Parcelable {

    String fecha;

    String lluvia1;
    String lluvia2;
    String lluvia3;
    String lluvia4;

    String nieve1;
    String nieve2;
    String nieve3;
    String nieve4;

    String stado1;
    String stado2;
    String stado3;
    String stado4;

    String direccion1;
    String direccion2;
    String direccion3;
    String direccion4;

    String velocidad1;
    String velocidad2;
    String velocidad3;
    String velocidad4;

    String temperatura1;
    String temperatura2;
    String temperatura3;
    String temperatura4;

    String humedad1;
    String humedad2;
    String humedad3;
    String humedad4;

    public Aemet(Parcel in) {
        fecha = in.readString();
        lluvia1 = in.readString();
        lluvia2 = in.readString();
        lluvia3 = in.readString();
        lluvia4 = in.readString();
        nieve1 = in.readString();
        nieve2 = in.readString();
        nieve3 = in.readString();
        nieve4 = in.readString();
        stado1 = in.readString();
        stado2 = in.readString();
        stado3 = in.readString();
        stado4 = in.readString();
        direccion1 = in.readString();
        direccion2 = in.readString();
        direccion3 = in.readString();
        direccion4 = in.readString();
        velocidad1 = in.readString();
        velocidad2 = in.readString();
        velocidad3 = in.readString();
        velocidad4 = in.readString();
        temperatura1 = in.readString();
        temperatura2 = in.readString();
        temperatura3 = in.readString();
        temperatura4 = in.readString();
        humedad1 = in.readString();
        humedad2 = in.readString();
        humedad3 = in.readString();
        humedad4 = in.readString();
    }

    public static final Creator<Aemet> CREATOR = new Creator<Aemet>() {
        @Override
        public Aemet createFromParcel(Parcel in) {
            return new Aemet(in);
        }

        @Override
        public Aemet[] newArray(int size) {
            return new Aemet[size];
        }
    };

    public Aemet() {

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLluvia1() {
        return lluvia1;
    }

    public void setLluvia1(String lluvia1) {
        this.lluvia1 = lluvia1;
    }

    public String getLluvia2() {
        return lluvia2;
    }

    public void setLluvia2(String lluvia2) {
        this.lluvia2 = lluvia2;
    }

    public String getLluvia3() {
        return lluvia3;
    }

    public void setLluvia3(String lluvia3) {
        this.lluvia3 = lluvia3;
    }

    public String getLluvia4() {
        return lluvia4;
    }

    public void setLluvia4(String lluvia4) {
        this.lluvia4 = lluvia4;
    }

    public String getNieve1() {
        return nieve1;
    }

    public void setNieve1(String nieve1) {
        this.nieve1 = nieve1;
    }

    public String getNieve2() {
        return nieve2;
    }

    public void setNieve2(String nieve2) {
        this.nieve2 = nieve2;
    }

    public String getNieve3() {
        return nieve3;
    }

    public void setNieve3(String nieve3) {
        this.nieve3 = nieve3;
    }

    public String getNieve4() {
        return nieve4;
    }

    public void setNieve4(String nieve4) {
        this.nieve4 = nieve4;
    }

    public String getStado1() {
        return stado1;
    }

    public void setStado1(String stado1) {
        this.stado1 = stado1;
    }

    public String getStado2() {
        return stado2;
    }

    public void setStado2(String stado2) {
        this.stado2 = stado2;
    }

    public String getStado3() {
        return stado3;
    }

    public void setStado3(String stado3) {
        this.stado3 = stado3;
    }

    public String getStado4() {
        return stado4;
    }

    public void setStado4(String stado4) {
        this.stado4 = stado4;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public String getDireccion3() {
        return direccion3;
    }

    public void setDireccion3(String direccion3) {
        this.direccion3 = direccion3;
    }

    public String getDireccion4() {
        return direccion4;
    }

    public void setDireccion4(String direccion4) {
        this.direccion4 = direccion4;
    }

    public String getVelocidad1() {
        return velocidad1;
    }

    public void setVelocidad1(String velocidad1) {
        this.velocidad1 = velocidad1;
    }

    public String getVelocidad2() {
        return velocidad2;
    }

    public void setVelocidad2(String velocidad2) {
        this.velocidad2 = velocidad2;
    }

    public String getVelocidad3() {
        return velocidad3;
    }

    public void setVelocidad3(String velocidad3) {
        this.velocidad3 = velocidad3;
    }

    public String getVelocidad4() {
        return velocidad4;
    }

    public void setVelocidad4(String velocidad4) {
        this.velocidad4 = velocidad4;
    }

    public String getTemperatura1() {
        return temperatura1;
    }

    public void setTemperatura1(String temperatura1) {
        this.temperatura1 = temperatura1;
    }

    public String getTemperatura2() {
        return temperatura2;
    }

    public void setTemperatura2(String temperatura2) {
        this.temperatura2 = temperatura2;
    }

    public String getTemperatura3() {
        return temperatura3;
    }

    public void setTemperatura3(String temperatura3) {
        this.temperatura3 = temperatura3;
    }

    public String getTemperatura4() {
        return temperatura4;
    }

    public void setTemperatura4(String temperatura4) {
        this.temperatura4 = temperatura4;
    }

    public String getHumedad1() {
        return humedad1;
    }

    public void setHumedad1(String humedad1) {
        this.humedad1 = humedad1;
    }

    public String getHumedad2() {
        return humedad2;
    }

    public void setHumedad2(String humedad2) {
        this.humedad2 = humedad2;
    }

    public String getHumedad3() {
        return humedad3;
    }

    public void setHumedad3(String humedad3) {
        this.humedad3 = humedad3;
    }

    public String getHumedad4() {
        return humedad4;
    }

    public void setHumedad4(String humedad4) {
        this.humedad4 = humedad4;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fecha);
        dest.writeString(lluvia1);
        dest.writeString(lluvia2);
        dest.writeString(lluvia3);
        dest.writeString(lluvia4);
        dest.writeString(nieve1);
        dest.writeString(nieve2);
        dest.writeString(nieve3);
        dest.writeString(nieve4);
        dest.writeString(stado1);
        dest.writeString(stado2);
        dest.writeString(stado3);
        dest.writeString(stado4);
        dest.writeString(direccion1);
        dest.writeString(direccion2);
        dest.writeString(direccion3);
        dest.writeString(direccion4);
        dest.writeString(velocidad1);
        dest.writeString(velocidad2);
        dest.writeString(velocidad3);
        dest.writeString(velocidad4);
        dest.writeString(temperatura1);
        dest.writeString(temperatura2);
        dest.writeString(temperatura3);
        dest.writeString(temperatura4);
        dest.writeString(humedad1);
        dest.writeString(humedad2);
        dest.writeString(humedad3);
        dest.writeString(humedad4);
    }
}
