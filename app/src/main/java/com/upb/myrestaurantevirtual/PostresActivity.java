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

public class PostresActivity extends AppCompatActivity {

    private MyAdapterPos myAdapter = null;
    private static ArrayList<Plato> l_postres = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_postres);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setData();

        myAdapter = new MyAdapterPos(this);
        ListView listView = findViewById(R.id.listaPostres);
        listView.setAdapter(myAdapter);

    }

    public void setData( ) {

        l_postres.clear();
        Plato postre01 = new Plato(
                getResources().getStringArray(R.array.Postres)[1],
                getResources().getStringArray(R.array.Postres)[2],
                R.drawable.postre01
        );
        l_postres.add(postre01);

        Plato postre02 = new Plato(
                getResources().getStringArray(R.array.Postres)[3],
                getResources().getStringArray(R.array.Postres)[4],
                R.drawable.postre02
        );
        l_postres.add(postre02);

        Plato postre03 = new Plato(
                getResources().getStringArray(R.array.Postres)[5],
                getResources().getStringArray(R.array.Postres)[6],
                R.drawable.postre03
        );
        l_postres.add(postre03);
    }

    public static class MyAdapterPos extends BaseAdapter {

        private Context mContext;
        public MyAdapterPos(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {

            return l_postres.size();
        }

        @Override
        public Object getItem(int position) {

            return l_postres.get(position);
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
            img.setImageDrawable(mContext.getResources().getDrawable(l_postres.get(position).image));
            TextView tTitle = (TextView) view.findViewById(R.id.title);
            tTitle.setText(l_postres.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.description);
            Tdescription.setText(l_postres.get(position).descripcion);

            return view;

        }
    }
}