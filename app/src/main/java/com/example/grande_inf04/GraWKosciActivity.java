package com.example.grande_inf04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import java.util.ArrayList;
import java.util.Random;

public class GraWKosciActivity extends AppCompatActivity {
    Button rollBones;
    int[] bonesList = {R.id.k1, R.id.k2, R.id.k3, R.id.k4, R.id.k5};
    int[] bonesImg = {R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6,};
    TextView thisScore;
    TextView sumScore;
    Button resetScoreBtn;
    int finalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gra_wkosci);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Random random = new Random();
        rollBones = findViewById(R.id.rollBones);
        thisScore = findViewById(R.id.thisScore);
        sumScore = findViewById(R.id.sumScore);
        resetScoreBtn = findViewById(R.id.resetScoreBtn);

        rollBones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Integer> rzuty = new ArrayList<Integer>();
                for (int id : bonesList) {
                    ImageView tempView = findViewById(id);
                    int newRandom = random.nextInt(6) + 1;
                    rzuty.add(newRandom);
                    tempView.setImageResource(bonesImg[newRandom - 1]);
                }
                int roundPoint = liczPunkty(rzuty);
                finalScore += roundPoint;
                thisScore.setText("Wynik tego losowania: " + roundPoint);
                sumScore.setText("Wynik gry: " + finalScore);

            }
        });
        resetScoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int id : bonesList) {
                    ImageView tempView = findViewById(id);
                    tempView.setImageResource(R.drawable.not_know);
                }
                finalScore = 0;
                sumScore.setText("Wynik gry: 0");
                thisScore.setText("Wynik tego losowania: 0");
            }
        });
    }

    private static int liczPunkty(ArrayList<Integer> rzuty) {
        int suma = 0;
        for (int i = 0; i < rzuty.size(); i++) {
            int liczbaDoSprawdzenia = rzuty.get(i);
            int ileTaLiczbaJest = 0;
            for (int j = 0; j < rzuty.size(); j++) {
                if (liczbaDoSprawdzenia == rzuty.get(j)) {
                    ileTaLiczbaJest++;
                }
            }
            if (ileTaLiczbaJest > 1) {
                suma += liczbaDoSprawdzenia;
            }
        }
        return suma;
    }
}