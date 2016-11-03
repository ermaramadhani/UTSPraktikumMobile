package com.example.my_pc.orderapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by My-PC on 03/11/2016.
 */
public class MenuDetailActivity extends AppCompatActivity {
    private TextView textnama;
    private TextView textdeskripsi;
    private ImageView imgview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_detail);

        //Initializing Views
        textnama = (TextView) findViewById(R.id.txt_nama);
        textdeskripsi = (TextView) findViewById(R.id.txt_deskripsi);
        imgview = (ImageView) findViewById(R.id.img_makan);

        //Getting intent
        Intent intent = getIntent();

        //Displaying values by fetching from intent
        textnama.setText(intent.getStringExtra(OrderFragment.intent_nama));
        textdeskripsi.setText(intent.getStringExtra(OrderFragment.intent_deskripsi));
        imgview.setImageResource(intent.getIntExtra(String.valueOf(OrderFragment.intent_image),0));

    }
}
