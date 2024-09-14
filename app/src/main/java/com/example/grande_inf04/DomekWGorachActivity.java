package com.example.grande_inf04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DomekWGorachActivity extends AppCompatActivity {

    Button likeIncrement;
    Button likeDecrement;
    TextView likesCount;
    int likesNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_domek_wgorach);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        likeIncrement = findViewById(R.id.likeIncrement);
        likeDecrement = findViewById(R.id.likeDecrement);
        likesCount = findViewById(R.id.likesCount);
        likeIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likesNum++;
                likesCount.setText(likesNum + " polubień");
            }
        });
        likeDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (likesNum > 0) {
                    likesNum--;
                    likesCount.setText(likesNum + " polubień");
                }
            }
        });
    }
}