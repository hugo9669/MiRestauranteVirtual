package com.upb.myrestaurantevirtual;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.upb.myrestaurantevirtual.databinding.ActivitySedeBinding;

public class SedeActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivitySedeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySedeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtener el fragmento del mapa y configurar el callback
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Definir coordenadas de las sedes
        LatLng sedeItagui = new LatLng(6.172523, -75.617489);
        LatLng sedePoblado = new LatLng(6.20824, -75.56792);
        LatLng sedeLaureles = new LatLng(6.244203, -75.591479);

        // Crear marcadores para las sedes
        mMap.addMarker(new MarkerOptions()
                .position(sedeItagui)
                .title("Sede Itagüí")
                .snippet("Sede principal, Cl. 40 #5448 a 5546- Itagüí, Antioquia"));

        mMap.addMarker(new MarkerOptions()
                .position(sedePoblado)
                .title("Sede Poblado")
                .snippet("Carrera 43A #1-50, El Poblado, Medellín, Antioquia"));

        mMap.addMarker(new MarkerOptions()
                .position(sedeLaureles)
                .title("Sede Laureles")
                .snippet("Circular 74B #39B-50, Laureles, Medellín, Antioquia"));

        // Ajustar la cámara para mostrar todas las sedes
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(sedeItagui);
        builder.include(sedePoblado);
        builder.include(sedeLaureles);
        LatLngBounds bounds = builder.build();
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));

        // Configurar tipo de mapa y zoom mínimo
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMinZoomPreference(12f);
    }
}
