package com.example.julolopop.datosxmltema3;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.XmlResourceParser;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ListView;
import android.widget.TextView;

import com.example.julolopop.datosxmltema3.adapter.AdapterAemet;
import com.example.julolopop.datosxmltema3.pojo.Aemet;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;

import cz.msebera.android.httpclient.entity.mime.Header;

public class Eje2Activity extends AppCompatActivity {

    ListView listView;
    XmlPullParser xmlPullParser;
    ArrayList<Aemet> aemetArrayList;
    AdapterAemet adapterAemet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eje2);

        this.listView = (ListView) findViewById(android.R.id.list);
        this.aemetArrayList = new ArrayList<>();

        descargarXml();

        this.adapterAemet = new AdapterAemet(this);


    }


    public void analizarAemet() throws XmlPullParserException,
            IOException {

        XmlPullParser xrp = xmlPullParser;
        Aemet aemet = null;
        boolean tem = false;
        boolean hum = false;

        int eventType = xrp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {


            if (eventType == XmlPullParser.START_TAG) {
                if (xrp.getName().equals("dia")) {
                    aemet = new Aemet();
                    aemet.setFecha(xrp.getAttributeValue(0));
                }


                if (xrp.getName().equals("prob_precipitacion")) {
                    try {
                        if (xrp.getAttributeValue(0).equals("00-06"))
                            aemet.setLluvia1(xrp.nextText());


                        if (xrp.getAttributeValue(0).equals("06-12"))
                            aemet.setLluvia2(xrp.nextText());

                        if (xrp.getAttributeValue(0).equals("12-18"))
                            aemet.setLluvia3(xrp.nextText());


                        if (xrp.getAttributeValue(0).equals("18-24"))
                            aemet.setLluvia4(xrp.nextText());
                    } catch (Exception e) {
                    }
                }
                if (xrp.getName().equals("cota_nieve_prov")) {
                    try {
                        if (xrp.getAttributeValue(0).equals("00-06"))
                            aemet.setNieve1(xrp.nextText());


                        if (xrp.getAttributeValue(0).equals("06-12"))
                            aemet.setNieve2(xrp.nextText());

                        if (xrp.getAttributeValue(0).equals("12-18"))
                            aemet.setNieve3(xrp.nextText());
                        if (xrp.getAttributeValue(0).equals("18-24"))
                            aemet.setNieve4(xrp.nextText());
                    } catch (Exception e) {
                    }
                }

                if (xrp.getName().equals("estado_cielo")) {
                    try {
                        if (xrp.getAttributeValue(0).equals("00-06"))
                            aemet.setStado1(xrp.getAttributeValue(1));
                        if (xrp.getAttributeValue(0).equals("06-12"))
                            aemet.setStado2(xrp.getAttributeValue(1));
                        if (xrp.getAttributeValue(0).equals("12-18"))
                            aemet.setStado3(xrp.getAttributeValue(1));
                        if (xrp.getAttributeValue(0).equals("18-24"))
                            aemet.setStado4(xrp.getAttributeValue(1));
                    } catch (Exception e) {
                    }
                }

                if (xrp.getName().equals("viento")) {
                    try {
                        if (xrp.getAttributeValue(0).equals("00-06")) {
                            while (!xrp.getName().equals("direccion")) {
                                eventType = xrp.next();
                            }
                            aemet.setDireccion1(xrp.nextText());

                            while (!xrp.getName().equals("velocidad")) {
                                eventType = xrp.next();
                            }
                            aemet.setVelocidad1(xrp.nextText());

                        }
                        if (xrp.getAttributeValue(0).equals("06-12")) {
                            while (!xrp.getName().equals("direccion")) {
                                eventType = xrp.next();
                            }
                            aemet.setDireccion2(xrp.nextText());

                            while (!xrp.getName().equals("velocidad")) {
                                eventType = xrp.next();
                            }
                            aemet.setVelocidad2(xrp.nextText());

                        }
                        if (xrp.getAttributeValue(0).equals("12-18")) {
                            while (!xrp.getName().equals("direccion")) {
                                eventType = xrp.next();
                            }
                            aemet.setDireccion3(xrp.nextText());


                            while (!xrp.getName().equals("velocidad")) {
                                eventType = xrp.next();
                            }
                            aemet.setVelocidad3(xrp.nextText());

                        }
                        if (xrp.getAttributeValue(0).equals("18-24")) {
                            while (!xrp.getName().equals("direccion")) {
                                eventType = xrp.next();
                            }

                            aemet.setDireccion4(xrp.nextText());

                            while (!xrp.getName().equals("velocidad")) {
                                eventType = xrp.next();
                            }
                            aemet.setVelocidad4(xrp.nextText());
                        }
                    } catch (Exception e) {
                    }
                }


                if (xrp.getName().equals("temperatura")) {
                    tem = true;
                }


                if (xrp.getName().equals("dato") && tem) {
                    try {
                        if (xrp.getAttributeValue(0).equals("06"))
                            aemet.setTemperatura1(xrp.nextText());
                    } catch (Exception e) {
                        aemet.setTemperatura1("");
                    }
                    try {
                        if (xrp.getAttributeValue(0).equals("12"))
                            aemet.setTemperatura2(xrp.nextText());
                    } catch (Exception e) {
                        aemet.setTemperatura2("");
                    }
                    try {
                        if (xrp.getAttributeValue(0).equals("18"))
                            aemet.setTemperatura3(xrp.nextText());
                    } catch (Exception e) {
                        aemet.setTemperatura3("");
                    }
                    try {
                        if (xrp.getAttributeValue(0).equals("24"))
                            aemet.setTemperatura4(xrp.nextText());
                    } catch (Exception e) {
                        aemet.setTemperatura4("");
                    }
                }

                if (xrp.getName().equals("humedad_relativa")) {
                    hum = true;
                }

                if (xrp.getName().equals("dato") && hum) {
                    try {
                        if (xrp.getAttributeValue(0).equals("06"))
                            aemet.setHumedad1(xrp.nextText());
                    } catch (Exception e) {
                        aemet.setHumedad1("");
                    }
                    try {
                        if (xrp.getAttributeValue(0).equals("12"))
                            aemet.setHumedad2(xrp.nextText());
                    } catch (Exception e) {
                        aemet.setHumedad2("");
                    }
                    try {
                        if (xrp.getAttributeValue(0).equals("18"))
                            aemet.setHumedad3(xrp.nextText());
                    } catch (Exception e) {
                        aemet.setHumedad3("");
                    }
                    try {
                        if (xrp.getAttributeValue(0).equals("24"))
                            aemet.setHumedad4(xrp.nextText());
                    } catch (Exception e) {
                        aemet.setHumedad4("");
                    }
                }


            }

            if (eventType == XmlPullParser.END_TAG) {
                if (xrp.getName().equals("temperatura")) {
                    tem = false;
                }
                if (xrp.getName().equals("humedad_relativa")) {
                    hum = false;
                }
                if (xrp.getName().equals("dia")) {
                    aemetArrayList.add(aemet);
                }
            }

            eventType = xrp.next();
        }

    }

    public void descargarXml() {

        final AsyncHttpClient client = new AsyncHttpClient();

        final ProgressDialog progreso = new ProgressDialog(this);
        String uri = "http://www.aemet.es/xml/municipios/localidad_29067.xml";
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
                    analizarAemet();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ArrayList<Aemet> aemets = new ArrayList<>();
                aemets.add(aemetArrayList.get(0));
                aemets.add(aemetArrayList.get(1));

                adapterAemet.addAll(aemets);
                listView.setAdapter(adapterAemet);


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


}
