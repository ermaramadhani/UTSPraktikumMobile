package com.example.my_pc.orderapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by My-PC on 03/11/2016.
 */
public class AboutFragment extends Fragment {

    //Root URL of our web service


    public AboutFragment() {
    }

    RelativeLayout view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = (RelativeLayout) inflater.inflate(R.layout.fragment_about, container, false);
        getActivity().setTitle("About");
        return view;
    }


}


