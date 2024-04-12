package com.example.mimenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    inicioFragment ini = new inicioFragment();
    copitoFragment cop = new copitoFragment();

    FrameLayout frm_copito;
    BottomNavigationView btn_menu;

    private Spinner spinnerRazas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerRazas = findViewById(R.id.spinnerRazas);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.razas, R.layout.activity_main);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerRazas.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Seleccionado: " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        frm_copito = findViewById(R.id.frm_copito);
        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_inicio){
                    loadfragment(ini);
                    return true;
                }else if (item.getItemId() == R.id.nav_producto){
                    loadfragment(cop);
                    return true;
                }
                return false;
            }
        });
    }
    public void  loadfragment(Fragment fr){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frm_copito,fr);
        ft.commit();
    }
}