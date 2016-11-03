package com.example.my_pc.orderapp.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.my_pc.orderapp.R;

import java.util.ArrayList;

/**
 * Created by My-PC on 03/11/2016.
 */
public class PayAdapter extends ArrayAdapter<String> {


    public final Activity context;
    ArrayList<String> namaArray = new ArrayList<String>();
    ArrayList<Double> hargaArray = new ArrayList<Double>();



    public PayAdapter(Activity context, ArrayList namaArray, ArrayList hargaArray)
    {
        super(context, R.layout.orderlist,namaArray);

        this.context=context;
        this.namaArray=namaArray;
        this.hargaArray=hargaArray;



    }
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.orderlist,null,true);

        TextView nama=(TextView) rowView.findViewById(R.id.txt_nama);
        TextView jumlah=(TextView) rowView.findViewById(R.id.txt_jumlah);
        TextView harga=(TextView) rowView.findViewById(R.id.txt_harga);

        nama.setText(namaArray.get(position));
        harga.setText(String.valueOf(hargaArray.get(position)));
        return rowView;
    }
}
