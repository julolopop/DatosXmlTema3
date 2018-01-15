package com.example.julolopop.datosxmltema3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button Eje1;
    Button Eje2;
    Button Eje3;
    Button Eje4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.Eje1 = (Button)findViewById(R.id.Eje1);
        this.Eje2 = (Button)findViewById(R.id.Eje2);
        this.Eje3 = (Button)findViewById(R.id.Eje3);
        this.Eje4 = (Button)findViewById(R.id.Eje4);


        this.Eje1.setOnClickListener(this);
        this.Eje2.setOnClickListener(this);
        this.Eje3.setOnClickListener(this);
        this.Eje4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Eje1:
                startActivity(new Intent(MainActivity.this,Eje1Activity.class));
                break;
            case R.id.Eje2:
                startActivity(new Intent(MainActivity.this,Eje2Activity.class));
                break;
            case R.id.Eje3:
                startActivity(new Intent(MainActivity.this,Eje3Activity.class));
                break;
            case R.id.Eje4:
                startActivity(new Intent(MainActivity.this,Eje4Activity.class));
                break;

        }
    }
}
