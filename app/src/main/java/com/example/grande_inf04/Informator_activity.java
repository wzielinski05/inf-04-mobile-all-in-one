package com.example.grande_inf04;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Informator_activity extends AppCompatActivity {

    Button prevBtn;
    Button nextBtn;
    EditText editNumImg;
    Switch isBlueSwitch;
    ImageView imageViewCat;
    int currentImg;
    LinearLayout mainLinerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_informator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int[] imgList = {R.drawable.kot1, R.drawable.kot2, R.drawable.kot3, R.drawable.kot4};
        currentImg = 0;
        prevBtn = findViewById(R.id.btn_prev);
        nextBtn = findViewById(R.id.btn_next);
        editNumImg = findViewById(R.id.editTextNumber);
        isBlueSwitch = findViewById(R.id.isBlueSwitch);
        imageViewCat = findViewById(R.id.imageViewCat);
        mainLinerLayout = findViewById(R.id.main);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImg < 3) {
                    currentImg++;
                } else {
                    currentImg = 0;
                }
                imageViewCat.setImageResource(imgList[currentImg]);
            }
        });
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImg > 1) {
                    currentImg--;
                } else {
                    currentImg = 3;
                }
                imageViewCat.setImageResource(imgList[currentImg]);
            }
        });
        editNumImg.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                Log.i("AAA", "onEditorAction: " + textView.getText().toString());
                int num = Integer.parseInt(textView.getText().toString());
                if (!(num < 1 || num > 4)) {
                    currentImg = num - 1;
                    imageViewCat.setImageResource(imgList[currentImg]);
                }
                return false;
            }
        });
        isBlueSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBlueSwitch.isChecked()) {
                    mainLinerLayout.setBackgroundResource(R.color.informator_bg3);
                } else {
                    mainLinerLayout.setBackgroundResource(R.color.informator_bg1);
                }
            }
        });

    }
}