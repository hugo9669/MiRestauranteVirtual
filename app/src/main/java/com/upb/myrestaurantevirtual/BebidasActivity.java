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

public class BebidasActivity extends AppCompatActivity {

    private MyAdapterBeb myAdapter = null;
    private static ArrayList<Plato> l_bebidas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bebidas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setData();

        myAdapter = new MyAdapterBeb(this);
        ListView listView = findViewById(R.id.listaBebidas);
        listView.setAdapter(myAdapter);
    }

    public void setData( ) {

        l_bebidas.clear();
        Plato bebida01 = new Plato(
                getResources().getStringArray(R.array.Bebidas)[1],
                getResources().getStringArray(R.array.Bebidas)[2],
                R.drawable.bebida01
        );
        l_bebidas.add(bebida01);

        Plato bebida02 = new Plato(
                getResources().getStringArray(R.array.Bebidas)[3],
                getResources().getStringArray(R.array.Bebidas)[4],
                R.drawable.bebida02
        );
        l_bebidas.add(bebida02);

        Plato bebida03 = new Plato(
                getResources().getStringArray(R.array.Bebidas)[5],
                getResources().getStringArray(R.array.Bebidas)[6],
                R.drawable.bebida03
        );
        l_bebidas.add(bebida03);
    }

    public static class MyAdapterBeb extends BaseAdapter {

        private Context mContext;
        public MyAdapterBeb(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {

            return l_bebidas.size();
        }

        @Override
        public Object getItem(int position) {

            return l_bebidas.get(position);
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
            img.setImageDrawable(mContext.getResources().getDrawable(l_bebidas.get(position).image));
            TextView tTitle = (TextView) view.findViewById(R.id.title);
            tTitle.setText(l_bebidas.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.description);
            Tdescription.setText(l_bebidas.get(position).descripcion);

            return view;

        }
    }
}