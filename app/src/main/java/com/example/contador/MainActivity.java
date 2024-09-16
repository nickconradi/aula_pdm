
package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setText("Espirro!");
        textView.setText("Você espirrou " + contador  +  "vezes");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++; // Incrementa o valor
                textView.setText("Você espirrou " + contador +  "vezes");
            }
        });

    }
}