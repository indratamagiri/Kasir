package com.example.user.kasir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.valueOf;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
    private Spinner spinner1, spinner2;
    String[] makanan,minuman;
    String b = "";String a="";
    private int quantitya,quantityb;
    private int Totalharga =0;
    Button button1,button2;
    EditText et1,et2,nama;
    makanan mkn = new makanan();
    Minuman minum = new Minuman();

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText refund = (EditText) findViewById(R.id.refund);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        nama = (EditText) findViewById(R.id.name);
        addmakanan();
        addminuman();
        buttontambahmenu();
        buttonbayar();
    }


    public void addmakanan(){
        et1 = (EditText) findViewById(R.id.exmakanan);
        spinner1 = (Spinner) findViewById(R.id.makanan);
        makanan = getResources().getStringArray(R.array.makanan);
        try {
            String i = et1.getText().toString().trim();
            quantitya = Integer.valueOf(i);   // tidak tau errornya gimana
        }catch (Exception e){

        };
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override


            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MainActivity.this, String.valueOf(spinner1.getSelectedItem())
                        , Toast.LENGTH_SHORT).show();

                if (makanan[position].equals(" Nasi Goreng ")) {
                     mkn.setharga(15000);
                }
                if (makanan[position].equals(" Sate ")) {
                    mkn.setharga(18000);
                }
                if (makanan[position].equals(" Mi Goreng ")) {
                    mkn.setharga(10000);
                }
                if (makanan[position].equals(" Sup buntut ")) {
                    mkn.setharga(20000);
                }
                if (makanan[position].equals(" Rendang ")) {
                    mkn.setharga(25000);
                }
                if (makanan[position].equals(" Mi Ayam ")) {
                    mkn.setharga(12000);
                }
                if (makanan[position].equals(" Ayam Bakar ")) {
                    mkn.setharga(20000);
                }
                if (makanan[position].equals(" Opor Ayam ")) {
                    mkn.setharga(20000);
                }
               OrderMakanan(makanan[position]);
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }

            public void addminuman(){
                et2 = (EditText) findViewById(R.id.exminuman);
                spinner2 = (Spinner) findViewById(R.id.minuman);
                minuman = getResources().getStringArray(R.array.minuman);
                String i = et2.getText().toString().trim(); //quantityb = Integer.valueOf(i);
                try {
                   quantityb = Integer.parseInt(i); // tidak tau errornya gimana
                }catch (Exception e){

                };
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override


                    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                        Toast.makeText(MainActivity.this,String.valueOf(spinner2.getSelectedItem())
                                ,Toast.LENGTH_SHORT).show();

                        if(minuman[position].equals(" Es Teh")){
                            minum.setharga(15000);
                        }
                        if(minuman[position].equals(" Hangat")){
                            minum.setharga(18000);
                        }
                        if(minuman[position].equals(" Lemon Tea ")){
                            minum.setharga(10000);
                        }
                        if(minuman[position].equals(" Jus Alpukat ")){
                            minum.setharga(20000);
                        }
                        if(minuman[position].equals(" Jus Jeruk ")){
                            minum.setharga(25000);
                        }
                        if(minuman[position].equals(" Jus Mangga ")){
                            minum.setharga(12000);
                        }
                        if(minuman[position].equals(" Soda Gembira ")){
                            minum.setharga(20000);
                        }
                        if(minuman[position].equals(" Jus Melon ")){
                            minum.setharga(20000);
                        }
                        Order(minuman[position]);
                    }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }



    public void buttontambahmenu(){
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                harga();
                settext();
            }
        });

    }

    public void buttonbayar() {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                harga();
                settext();
              //  bayar();
                try {
                    bayar();
                }catch (Exception e){

                }

            }
        });
    }

    public void bayar(){
        EditText bayaran = (EditText) findViewById(R.id.refund);
        String d = bayaran.getText().toString().trim();
        final   int q = Integer.parseInt(d); // <- tah errornya gimana gak ngerti lagi
        int harusbayar = q - Totalharga;
        TextView change = (TextView)findViewById(R.id.tvchange);
        change.setText("Rp"+harusbayar);
    }
    public void harga(){
        Totalharga += (mkn.getHarga()*quantitya)+(minum.getHarga()*quantityb);
        mkn.setTotalharga(0);minum.setTotalharga(0);
    }

    private void  Order(String order){
        b += order;
        minum.setOrder(b);

    }

    public void  OrderMakanan(String order){
        a += order;
        mkn.setOrder(a);

    }
    public void settext(){
        TextView name = (TextView)findViewById(R.id.tvName);
        TextView food = (TextView)findViewById(R.id.tvfood);
        TextView qfood = (TextView)findViewById(R.id.tvqfood);
        TextView drink = (TextView)findViewById(R.id.tvdrink);
        TextView qdrink = (TextView)findViewById(R.id.tvqdrink);
        TextView price = (TextView)findViewById(R.id.tvprice);
        name.setText(""+nama.getText());
        food.setText(""+mkn.getOrder());
        qfood.setText(""+mkn.getQuantity());
        drink.setText(""+minum.getOrder());
        qdrink.setText(""+minum.getQuantity());
        price.setText("Rp."+Totalharga);
    }


}
