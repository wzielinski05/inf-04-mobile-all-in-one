package com.example.grande_inf04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnInformator;
    Button btnRejestrujKonto;
    Button btnDomekGora;
    Button btnLista;
    Button btnCzcionka;
    Button btnWet;
    Button btnKosci;

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
        btnInformator = findViewById(R.id.btn_informator);
        btnRejestrujKonto = findViewById(R.id.btn_rejestruj_konto);
        btnDomekGora = findViewById(R.id.btn_domek_gora);
        btnLista = findViewById(R.id.btn_lista);
        btnCzcionka = findViewById(R.id.btn_czcionka);
        btnWet = findViewById(R.id.btn_weterynarz);
        btnKosci = findViewById(R.id.btn_kosci);

        btnInformator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Informator_activity.class);
                startActivity(intent);
            }
        });
        btnRejestrujKonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RejestrujKontoActivity.class);
                startActivity(intent);
            }
        });
        btnDomekGora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DomekWGorachActivity.class);
                startActivity(intent);
            }
        });
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListaActivity.class);
                startActivity(intent);
            }
        });
        btnCzcionka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CzcionkaActivity.class);
                startActivity(intent);
            }
        });
        btnWet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WeterynarzActivity.class);
                startActivity(intent);
            }
        });
        btnKosci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GraWKosciActivity.class);
                startActivity(intent);
            }
        });
    }
}