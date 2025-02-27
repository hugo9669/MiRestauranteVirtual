package com.upb.myrestaurantevirtual;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String[] CATEGORIAS = new String [] {"Entrada" , "Plato fuerte" , "Bebida" , "Postres" , "Licor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lv = findViewById(android.R.id.list);

        ListAdapter la = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, CATEGORIAS);

        lv.setAdapter(la);

        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){

        switch (i){

            case 0: Intent intencion = new Intent(this, EntradasActivity.class);
                startActivity(intencion);
                break;

            case 1: Intent intencion1 = new Intent(this, PlatosFuertesActivity.class);
                startActivity(intencion1);
                break;

            case 2: Intent intencion2 = new Intent(this, BebidasActivity.class);
                startActivity(intencion2);
                break;

            case 3: Intent intencion3 = new Intent(this, PostresActivity.class);
                startActivity(intencion3);
                break;

            case 4: Intent intencion4 = new Intent(this, LicoresActivity.class);
                startActivity(intencion4);
                break;

        }

    }

}