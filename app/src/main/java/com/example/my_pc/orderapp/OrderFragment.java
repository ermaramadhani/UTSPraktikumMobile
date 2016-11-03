package com.example.my_pc.orderapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.my_pc.orderapp.Adapter.OrderAdapter;

import java.util.ArrayList;

/**
 * Created by My-PC on 03/11/2016.
 */
public class OrderFragment extends Fragment {

    public OrderFragment() {
        // Required empty public constructor
    }

    public static final String intent_nama = "nama";
    public static final String intent_deskripsi = "deskripsi";
    public static final Integer intent_image = 0;
    public static ArrayList<String> datacheckbox = new ArrayList<String>();
    public static ArrayList<Double> dataharga = new ArrayList<Double>();


    String[] namamakanan ={
            "Pretty Coffee",
            "Cute Smoothie",
            "Sweet Pastry",
            "Handsome Bekakak",
            "Coco Banana"
    };

    Integer[] imgid={
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5
    };

    String [] deskripsi=
            {
                    "Drink me and you will cenghar!",
                    "Health is more than everything and this smoothie is so healthy.",
                    "Get me for your appetizer!",
                    "Look at me! So handsome, don't me?",
                    "If you love every long thing, you can choose me!"

            };
    double [] harga =
            {
                    25000,
                    28000,
                    18000,
                    55000,
                    17000
            };


    LinearLayout view;
    ListView list;
    Button btn_pesan;
    CheckBox checkBox;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = (LinearLayout) inflater.inflate(R.layout.fragment_order, container, false);
        btn_pesan=(Button) view.findViewById(R.id.btn_pesan);
        checkBox = (CheckBox)view.findViewById(R.id.checkBox);
        getActivity().setTitle("Menu");

        OrderAdapter adapter=new OrderAdapter(getActivity(),namamakanan,harga,imgid);
        list=(ListView) view.findViewById(R.id.listpesanan);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getActivity(), MenuDetailActivity.class);
                intent.putExtra(intent_nama,namamakanan[position]);
                intent.putExtra(intent_deskripsi,deskripsi[position]);
                intent.putExtra(String.valueOf(intent_image), imgid[position]);

                startActivity(intent);

            }
        });


        btn_pesan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub


                Intent i = new Intent(getActivity(), PayActivity.class);
                startActivity(i);

                //Toast.makeText(getActivity(),"Yang dipilih = "+ datacheckbox,Toast.LENGTH_SHORT).show();




            }
        });


        return view;
    }


}
