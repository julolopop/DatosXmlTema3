package com.example.julolopop.datosxmltema3;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class Eje1Activity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eje1);

        textView = (TextView)findViewById(R.id.txv_TextoXml);


        try {
            textView.setText(analizarEmpresa());
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String analizarEmpresa() throws XmlPullParserException,
            IOException {
        StringBuilder cadena = new StringBuilder();
        XmlResourceParser xrp = getResources().getXml(R.xml.empresa);
        int sueldoMinimo = 99999;
        int sueldoMaximo=0;
        int edadMedia=0;
        int edad =0;
        int count =0;
        int sueldo;

        int eventType = xrp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {

            if (eventType == XmlPullParser.START_TAG) {
                if (xrp.getName().equals("nombre")) {
                    cadena.append("\nNombre : " + xrp.nextText());
                }
                if (xrp.getName().equals("edad")) {
                    edad = Integer.parseInt(xrp.nextText());
                    edadMedia += edad;
                    count++;
                    cadena.append("\nEdad : " + edad);
                }

                if (xrp.getName().equals("puesto")) {
                    sueldo = Integer.parseInt(xrp.getAttributeValue(0));
                    if(sueldo > sueldoMaximo){
                        sueldoMaximo = sueldo;
                    }
                    if(sueldo < sueldoMinimo){
                        sueldoMinimo = sueldo;
                    }

                    cadena.append("\nSueldo : " + sueldo);
                    cadena.append("\nPuesto : " + xrp.nextText());
                }
            }


            if (eventType == XmlPullParser.END_TAG)
                if (xrp.getName().equals("empleado"))
                    cadena.append("\n\n");


            eventType = xrp.next();
        }

        edadMedia /= count;

        cadena.append("\nEdad Media : "+edadMedia+
                "\nSueldo Maximo : "+sueldoMaximo+
                "\nSueldo Minimo : "+sueldoMinimo);

        return cadena.toString();
    }
}
