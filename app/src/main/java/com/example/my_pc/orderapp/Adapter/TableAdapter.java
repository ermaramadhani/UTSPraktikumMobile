package com.example.my_pc.orderapp.Adapter;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_pc.orderapp.TableFragment;
import com.example.my_pc.orderapp.R;

import java.util.ArrayList;
public class TableAdapter extends ArrayAdapter<String> {

    public final Activity context;
    public final String[] item;
    ArrayList<String> tersedia = new ArrayList<String>();

    public TableAdapter(Activity context, String[] item, ArrayList tersedia)
    {
        super(context, R.layout.foodlist,item);

        this.context=context;
        this.item=item;
        this.tersedia=tersedia;


    }
    public View getView(final int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.tablelist,null,true);

        TextView nama=(TextView) rowView.findViewById(R.id.txt_meja);
        TextView sedia=(TextView) rowView.findViewById(R.id.txt_sedia);
        CheckBox cekbox=(CheckBox)rowView.findViewById((R.id.cek_meja)) ;


        nama.setText(item[position]);
        if(tersedia.get(position).equals("Available"))
        {
            sedia.setTextColor(Color.GREEN);
            sedia.setText(tersedia.get(position));
            cekbox.setChecked(false);
        }
        else
        {
            sedia.setTextColor(Color.RED);
            sedia.setText(tersedia.get(position));
            cekbox.setChecked(true);
        }


        cekbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {
                    TableFragment.ketersediaan.set(position,"Nonavailable");
                    Toast.makeText(getContext(),item[position] + " Booked",Toast.LENGTH_SHORT ).show();
                }
                else
                {
                    TableFragment.ketersediaan.set(position,"Available");
                    Toast.makeText(getContext(),item[position] + " Available",Toast.LENGTH_SHORT ).show();
                }
                notifyDataSetChanged();
            }
        });





        /*else
        {
            sedia.setText(tersedia[position]);
            sedia.setTextColor(Color.RED);
            cekbox.setChecked(true);

        }**/



        return rowView;
    }
}
