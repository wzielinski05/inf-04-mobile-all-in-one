package com.example.grande_inf04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RejestrujKontoActivity extends AppCompatActivity {

    //    INF.04-01-22.01
    //    INF.04-01-21-06
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextPassword2;
    Button submitBtn;
    TextView messagesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rejestruj_konto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        editTextPassword2 = findViewById(R.id.editTextTextPassword2);
        submitBtn = findViewById(R.id.submit);
        messagesTextView = findViewById(R.id.messages);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextEmail.getText().toString().contains("@")) {
                    messagesTextView.setText("Nieprawidłowy adres e-mail \n");
                } else if (!editTextPassword.getText().toString().equals(editTextPassword2.getText().toString())) {
                    messagesTextView.setText("Hasła różnią się");
                } else {
                    messagesTextView.setText("Witaj " + editTextEmail.getText());
                }
            }
        });
    }
}