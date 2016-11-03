package com.example.my_pc.orderapp;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.my_pc.orderapp.Adapter.PayAdapter;

import java.util.ArrayList;

public class PayActivity extends AppCompatActivity {

    ListView list;
    EditText et_total,et_bayar,et_kembalian;
    Button btn_bayar;
    Double total=0.0,kembalian=0.0,bayar=0.0;
    ArrayList<Double> totalharga = new ArrayList<Double>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        et_total=(EditText)findViewById(R.id.et_total);
        et_kembalian=(EditText)findViewById(R.id.et_kembali);
        et_bayar=(EditText)findViewById(R.id.et_bayar);
        btn_bayar=(Button)findViewById(R.id.btn_bayar);

        for(int i = 0; i<1; i++)
        {

            totalharga.add(OrderFragment.dataharga.get(0));

        }


        total = 0.0;
        for(int i = 0; i< 1; i++)
        {

            total=total+totalharga.get(i);

        }
        System.out.print(total);
        et_total.setText(String.valueOf(total));

        et_bayar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {

                try
                {
                    bayar=Double.valueOf(String.valueOf(et_bayar.getText()));
                    if((bayar==null)||(bayar==0))
                    {
                        et_bayar.setError("Masih Kurang");
                    }
                    else if(bayar>=total)
                    {
                        kembalian=bayar-total;
                        btn_bayar.setClickable(true);


                    }
                    else
                    {
                        kembalian=bayar-total;
                        et_bayar.setError("Masih Kurang");
                    }
                    et_kembalian.setText(String.valueOf(kembalian));
                }
                catch (NumberFormatException e)
                {

                    et_bayar.setText(String.valueOf(0));
                    et_kembalian.setText(String.valueOf(total));
                    et_bayar.setError("Masih Kurang");
                }
            }

        });
        list=(ListView)findViewById(R.id.listpembayaran);
        PayAdapter adapter=new PayAdapter(this, OrderFragment.datacheckbox, OrderFragment.dataharga);
        list.setAdapter(adapter);

    }
}
