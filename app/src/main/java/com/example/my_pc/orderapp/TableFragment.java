package com.example.my_pc.orderapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.my_pc.orderapp.Adapter.TableAdapter;

import java.util.ArrayList;

/**
 * Created by My-PC on 03/11/2016.
 */
public class TableFragment extends Fragment {

    String[] ListMeja ={
            "Table 1",
            "Table 2",
            "Table 3",
            "Table 4",
            "Table 5",
            "Table 6"
    };

    public static ArrayList<String> ketersediaan = new ArrayList<String>();



    public String[] sssKetersediaan=
            {
                    "Available",
                    "Available",
                    "Available",
                    "Available",
                    "Available",
                    "Available"
            };



    public TableFragment() {
    }



    LinearLayout view;
    ListView list;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ketersediaan.add("Available");
        ketersediaan.add("Available");
        ketersediaan.add("Available");
        ketersediaan.add("Available");
        ketersediaan.add("Available");
        ketersediaan.add("Available");


        view = (LinearLayout) inflater.inflate(R.layout.fragment_table, container, false);
        getActivity().setTitle("Table Book");


        TableAdapter adapter=new TableAdapter(getActivity(),ListMeja, ketersediaan);
        list=(ListView) view.findViewById(R.id.list_meja);
        list.setAdapter(adapter);



        return view;
    }





}
