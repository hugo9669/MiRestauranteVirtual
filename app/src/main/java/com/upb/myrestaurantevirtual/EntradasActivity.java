package com.upb.myrestaurantevirtual;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.upb.myrestaurantevirtual.Plato;

import java.util.ArrayList;

public class EntradasActivity extends AppCompatActivity {

    private MyAdapterBeb myAdapter = null;
    private static ArrayList<Plato> l_entradas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_entradas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setData();

        myAdapter = new MyAdapterBeb(this);
        ListView listView = findViewById(R.id.listaEntradas);
        listView.setAdapter(myAdapter);
    }

    public void setData( ) {

        l_entradas.clear();
        Plato entrada01 = new Plato(
                getResources().getStringArray(R.array.entradas)[1],
                getResources().getStringArray(R.array.entradas)[2],
                R.drawable.entrada01
        );
        l_entradas.add(entrada01);

        Plato entrada02 = new Plato(
                getResources().getStringArray(R.array.entradas)[3],
                getResources().getStringArray(R.array.entradas)[4],
                R.drawable.entrada02
        );
        l_entradas.add(entrada02);

        Plato entrada03 = new Plato(
                getResources().getStringArray(R.array.entradas)[5],
                getResources().getStringArray(R.array.entradas)[6],
                R.drawable.entrada03
        );
        l_entradas.add(entrada03);
    }

    public static class MyAdapterBeb extends BaseAdapter {

        private Context mContext;
        public MyAdapterBeb(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {

            return l_entradas.size();
        }

        @Override
        public Object getItem(int position) {

            return l_entradas.get(position);
        }

        @Override
        public long getItemId(int i) {

            return 0;
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;

            if (convertView == null) {
                // Make up a new view
                LayoutInflater inflater = (LayoutInflater) mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.menu_cat_layout, null);
            } else {
                // Use convertView if it is available
                view = convertView;
            }

            // Example to get an image resource
            ImageView img = (ImageView) view.findViewById(R.id.image);
            img.setImageDrawable(mContext.getResources().getDrawable(l_entradas.get(position).image));
            TextView tTitle = (TextView) view.findViewById(R.id.title);
            tTitle.setText(l_entradas.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.description);
            Tdescription.setText(l_entradas.get(position).descripcion);

            return view;

        }
    }
}