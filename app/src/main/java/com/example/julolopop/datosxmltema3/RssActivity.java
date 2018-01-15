package com.example.julolopop.datosxmltema3;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.julolopop.datosxmltema3.pojo.Bici;
import com.example.julolopop.datosxmltema3.pojo.Noticias;
import com.example.julolopop.datosxmltema3.pojo.Rss;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class RssActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayAdapter<Rss> adapter;
    ArrayList<Rss> rss;
    XmlPullParser xmlPullParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);

        this.listView = (ListView) findViewById(android.R.id.list);
        adapter = new ArrayAdapter<Rss>(this, android.R.layout.simple_list_item_1);
        rss = new ArrayList<>();


        descargarXml(getIntent().getStringExtra("URI"));


        this.listView.setAdapter(adapter);
        this.listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Uri uri = Uri.parse(rss.get(position).getLink() );
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }


    public void analizarBici() throws XmlPullParserException,
            IOException {

        XmlPullParser xrp = xmlPullParser;
        Rss rss1 = null;
        boolean item = false;

        int eventType = xrp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {


            if (eventType == XmlPullParser.START_TAG) {
                if (xrp.getName().equals("item")) {
                    rss1 = new Rss();
                    item = true;

                }

                if (item) {
                    if (xrp.getName().equals("title")) {
                        rss1.setTitulo( xrp.nextText());
                    }
                    if (xrp.getName().equals("description")) {
                        rss1.setDescripcion( xrp.nextText());
                    }
                    if (xrp.getName().equals("link")) {
                        rss1.setLink(xrp.nextText());
                    }
                }

            }

            if (eventType == XmlPullParser.END_TAG) {
                if (xrp.getName().equals("item")) {
                    rss.add(rss1);
                    item = false;
                }
            }


            eventType = xrp.next();

        }

    }

    public void descargarXml(String uri) {

        final AsyncHttpClient client = new AsyncHttpClient();

        final ProgressDialog progreso = new ProgressDialog(this);
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

                adapter.addAll(rss);
                listView.setAdapter(adapter);


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
