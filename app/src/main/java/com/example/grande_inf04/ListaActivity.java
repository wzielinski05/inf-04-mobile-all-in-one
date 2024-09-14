package com.example.grande_inf04;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaActivity extends AppCompatActivity {
    //    INF.04-01-23.01
//     INF.04-02-23.01
    EditText newElementEdit;
    Button submit;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        newElementEdit = findViewById(R.id.editElement);
        submit = findViewById(R.id.submit);
        listView = findViewById(R.id.listView);
        ArrayList<String> elementsList = new ArrayList<String>(Arrays.asList(new String[]{"Zakupy: chleb, masło, ser", "Do zrobienia: obiad, umyć podłogi", "weekend: kino, spacer"}));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_element, R.id.list_item, elementsList);
        listView.setAdapter(arrayAdapter);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elementsList.add(newElementEdit.getText().toString());
                arrayAdapter.notifyDataSetChanged();

            }
        });
    }
}