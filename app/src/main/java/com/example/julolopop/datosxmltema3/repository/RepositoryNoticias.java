package com.example.julolopop.datosxmltema3.repository;

import android.os.Bundle;

import com.example.julolopop.datosxmltema3.pojo.Noticias;

import java.util.ArrayList;

/**
 * Created by Julolopop on 15/01/2018.
 */

public class RepositoryNoticias {
    public static RepositoryNoticias instance;
    private ArrayList<Noticias> noticias;

    public static RepositoryNoticias newInstance() {
        if(instance == null)
            instance = new RepositoryNoticias();
        return instance;
    }

    public RepositoryNoticias() {
        this.noticias = new ArrayList<>();


        noticias.add(new Noticias("ElPais", "http://ep00.epimg.net/rss/elpais/portada.xml"));
        noticias.add(new Noticias("ElMundo", "http://estaticos.elmundo.es/elmundo/rss/espana.xml"));
    }

    public ArrayList<Noticias> getNoticias() {
        return noticias;
    }

    public void addNoticias(Noticias noticia){
        noticias.add(noticia);
    }
}
