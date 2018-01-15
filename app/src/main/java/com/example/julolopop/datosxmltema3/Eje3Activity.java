package com.example.julolopop.datosxmltema3;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.julolopop.datosxmltema3.adapter.AdapterAemet;
import com.example.julolopop.datosxmltema3.adapter.AdapterBici;
import com.example.julolopop.datosxmltema3.adapter.AdapterBici2;
import com.example.julolopop.datosxmltema3.pojo.Aemet;
import com.example.julolopop.datosxmltema3.pojo.Bici;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class Eje3Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    XmlPullParser xmlPullParser;
    ArrayList<Bici> biciArrayList;
    ArrayList<Bici> bici2ArrayList;
    AdapterBici adapterBici;
    AdapterBici2 adapterBici2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eje3);

        this.listView = (ListView) findViewById(android.R.id.list);
        this.biciArrayList = new ArrayList<>();
        this.bici2ArrayList = new ArrayList<>();
        this.adapterBici2 = new AdapterBici2(this);

        descargarXml();

        this.adapterBici = new AdapterBici(this);

        this.listView.setOnItemClickListener(this);
    }





    public void analizarBici() throws XmlPullParserException,
            IOException {

        XmlPullParser xrp = xmlPullParser;
        Bici bici = null;

        int eventType = xrp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {


            if (eventType == XmlPullParser.START_TAG) {
                if (xrp.getName().equals("estacion-bicicleta")) {
                    bici = new Bici();
                }

                if(xrp.getName().equals("id")){
                    bici.setId(xrp.nextText());
                }
                if(xrp.getName().equals("about")){
                    bici.setAbout(xrp.nextText());
                }
                if(xrp.getName().equals("title")){
                    bici.setTitulo(xrp.nextText());
                }
                if(xrp.getName().equals("estado")){
                    bici.setEstado(xrp.nextText());
                }
                if(xrp.getName().equals("bicisDisponibles")){
                    bici.setBicisDisponibles(xrp.nextText());
                }
                if(xrp.getName().equals("anclajesDisponibles")){
                    bici.setAnclajesDisponibles(xrp.nextText());
                }
                if(xrp.getName().equals("coordinates")){
                    bici.setCordenadas(xrp.nextText());
                }

            }

            if (eventType == XmlPullParser.END_TAG) {
                if (xrp.getName().equals("estacion-bicicleta")) {
                    biciArrayList.add(bici);
                }
            }


            eventType = xrp.next();

        }

    }

    public void descargarXml() {

        final AsyncHttpClient client = new AsyncHttpClient();

        final ProgressDialog progreso = new ProgressDialog(this);
        String uri = "https://www.zaragoza.es/sede/servicio/urbanismo-infraestructuras/estacion-bicicleta.xml";
        client.get(uri, new TextHttpResponseHandler() {


            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {
                progreso.dismiss();
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {

                String a = "";

                for (int i = 0; i < responseString.length(); i++) {
                    if (responseString.toCharArray()[i] == '\n' || responseString.toCharArray()[i] == '\t') {

                    } else {
                        a += responseString.toCharArray()[i];
                    }
                }


                xmlPullParser = Xml.newPullParser();
                try {
                    xmlPullParser.setInput(new StringReader(a));
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }


                try {
                    analizarBici();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                adapterBici.addAll(biciArrayList);
                listView.setAdapter(adapterBici);


                progreso.dismiss();
            }

            @Override
            public void onStart() {
                progreso.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progreso.setMessage("Descargando ...");
                progreso.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        client.cancelAllRequests(true);
                    }
                });
                progreso.show();
            }


        });


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        bici2ArrayList.add(biciArrayList.get(position));

        adapterBici2.clear();
        adapterBici2.addAll(bici2ArrayList);

        listView.setAdapter(adapterBici2);

    }
}
