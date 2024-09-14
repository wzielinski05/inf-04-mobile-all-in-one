package com.example.grande_inf04;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WeterynarzActivity extends AppCompatActivity {
    //    INF.04-02-24.01-SG
//    INF.04-01-24.01-SD
    ListView wetListView;
    SeekBar seekBar;
    TextView ageInfo;
    int age;
    EditText editPurpose;
    EditText editTime;
    Button submitBtn;
    EditText ownerEdit;
    String animal;
    TextView wizytaInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weterynarz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        wetListView = findViewById(R.id.listView);
        seekBar = findViewById(R.id.seekBarAge);
        ageInfo = findViewById(R.id.ageInfo);
        editPurpose = findViewById(R.id.editTextPurpose);
        editTime = findViewById(R.id.editTextTime);
        submitBtn = findViewById(R.id.submit);
        ownerEdit = findViewById(R.id.editOwner);
        wizytaInfo = findViewById(R.id.wizyta);
        animal = "";
        String[] animals = {"Pies", "Kot", "Świnka morska"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.wet_list_element, R.id.wetListItem, animals);
        wetListView.setAdapter(arrayAdapter);
        wetListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("AAA", "onItemClick: " + i);
                if (i == 0) {
                    age = 18;
                } else if (i == 1) {
                    age = 20;
                } else if (i == 2) {
                    age = 9;
                }
                seekBar.setProgress(age);
                animal = animals[i];
                ageInfo.setText("Ile ma lat? " + age);

            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                age = i;
                seekBar.setProgress(age);
                ageInfo.setText("Ile ma lat? " + age);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wizytaInfo.setText(ownerEdit.getText() + ", " + animal + ", " + age + ", " + editPurpose.getText() + ", " + editTime.getText());
            }
        });


    }
}