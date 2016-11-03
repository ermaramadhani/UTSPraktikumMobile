package com.example.my_pc.orderapp.Adapter;
import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_pc.orderapp.OrderFragment;
import com.example.my_pc.orderapp.R;

public class OrderAdapter extends ArrayAdapter<String> {

    public final Activity context;
    public final String[] item;
    public final double[] item1;
    public final Integer[] imgid;
    Dialog dialog;
    View dialogView;
    LayoutInflater inflater;

    TextView nama, subnama, jumlah;
    ImageView gambar;
    public OrderAdapter(Activity context, String[] item, double[] item1, Integer[] imgid)
    {
        super(context, R.layout.foodlist,item);

        this.context=context;
        this.item=item;
        this.item1=item1;
        this.imgid=imgid;

    }



    public View getView(final int position, View view, ViewGroup parent)
    {




        inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.foodlist,null,true);

        final CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.checkBox);
        nama=(TextView) rowView.findViewById(R.id.txt_nama);
        subnama=(TextView) rowView.findViewById(R.id.txt_harga);
        jumlah=(TextView) rowView.findViewById(R.id.txt_jumlah);

        ImageView gambar=(ImageView) rowView.findViewById(R.id.img_makanan);


        nama.setText(item[position]);
        subnama.setText("Rp"+String.valueOf(item1[position]));
        gambar.setImageResource(imgid[position]);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    dialog = new Dialog(context);
                    dialog.setTitle("Ordered");

                }else{
                    Toast.makeText(getContext(),item[position]+ " Delete",Toast.LENGTH_SHORT).show();
                    OrderFragment.datacheckbox.remove(OrderFragment.datacheckbox.get(position));
                    OrderFragment.dataharga.remove(OrderFragment.dataharga.get(position));

                }






            }
        });

        return rowView;
    }
}