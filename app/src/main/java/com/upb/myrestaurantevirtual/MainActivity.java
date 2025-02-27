package com.upb.myrestaurantevirtual;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void consultarSedes (View v){
        Intent i = new Intent(this,SedeActivity.class);
        startActivity(i);
    }

    public void verMenu (View v){
        Intent i = new Intent(this,MenuActivity.class);
        startActivity(i);
    }

    public void realizarReserva (View v){
        String phone = "+573107412963";
        String message = "Hola, esperamos que te encuentres bien hoy. ¿Que podemos hacer por ti?";
        Uri uri = Uri.parse("whatsapp://send?phone=" + phone + "&text=" + Uri.encode(message));

        PackageManager pm = getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);

        i.setData(uri);
        startActivity(i);

        if (i != null) {
            startActivity(i);
        } else {
            Toast.makeText(this, "WhatsApp no está instalado en este dispositivo", Toast.LENGTH_SHORT).show();
        }
    }
}