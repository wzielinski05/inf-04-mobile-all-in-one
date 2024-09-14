package com.example.grande_inf04;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CzcionkaActivity extends AppCompatActivity {
    //    INF04-02-23.06
    TextView textViewCytat;
    SeekBar seekBar;
    Button btnChangeCytat;
    int currentCytat = 0;
    TextView sizeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_czcionka);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String[] cytaty = {"Dzień dobry", "Good morning", "Buenos Dias"};
        textViewCytat = findViewById(R.id.cytat);
        seekBar = findViewById(R.id.seekBar);
        btnChangeCytat = findViewById(R.id.button);
        sizeInfo = findViewById(R.id.sizeInfo);
        btnChangeCytat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentCytat < 2) {
                    currentCytat++;
                } else {
                    currentCytat = 0;
                }
                textViewCytat.setText(cytaty[currentCytat]);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewCytat.setTextSize(i);
                sizeInfo.setText("Rozmiar: " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}