package com.example.julolopop.datosxmltema3;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.julolopop.datosxmltema3.pojo.Noticias;
import com.example.julolopop.datosxmltema3.repository.RepositoryNoticias;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;

public class InicializarNoticiasActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_nombre;
    EditText edt_web;
    Button btn_ok;
    Button btn_cancelar;
    String nombre;
    String web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicializar_noticias);

        edt_nombre = (EditText) findViewById(R.id.edt_nombre);
        edt_web = (EditText) findViewById(R.id.edt_url);
        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_cancelar = (Button) findViewById(R.id.btn_cancelar);


        btn_ok.setOnClickListener(this);
        btn_cancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                nombre = edt_nombre.getText().toString();
                web = edt_web.getText().toString();

                try {
                    descargarXml(web);
                } catch (Exception e) {
                    Toast.makeText(InicializarNoticiasActivity.this, "Problemas con la URL", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(InicializarNoticiasActivity.this, Eje4Activity.class));
                }
                break;
            case R.id.btn_cancelar:
                startActivity(new Intent(InicializarNoticiasActivity.this, Eje4Activity.class));
                break;
        }
    }


    public void descargarXml(String uri) {

        final AsyncHttpClient client = new AsyncHttpClient();

        final ProgressDialog progreso = new ProgressDialog(this);
        client.get(uri, new TextHttpResponseHandler() {


            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {

                Toast.makeText(InicializarNoticiasActivity.this, "Problemas con la URL", Toast.LENGTH_LONG).show();
                startActivity(new Intent(InicializarNoticiasActivity.this, Eje4Activity.class));
                progreso.dismiss();
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {

                String version = responseString.substring(responseString.indexOf("s version=") + 11, responseString.indexOf("s version=") + 14);

                if (version.equals("2.0")) {

                    Toast.makeText(InicializarNoticiasActivity.this, "Link agregado correctamente", Toast.LENGTH_LONG).show();
                    RepositoryNoticias.newInstance().addNoticias(new Noticias(nombre, web));
                } else {

                    Toast.makeText(InicializarNoticiasActivity.this, "Problemas con la version", Toast.LENGTH_LONG).show();
                }


                startActivity(new Intent(InicializarNoticiasActivity.this, Eje4Activity.class));

                progreso.dismiss();
            }

            @Override
            public void onStart() {
                progreso.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progreso.setMessage("Comprobando ...");
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
