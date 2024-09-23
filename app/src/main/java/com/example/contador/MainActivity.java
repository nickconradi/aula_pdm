package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText edMin, edMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        edMin = findViewById(R.id.edMin);
        edMax = findViewById(R.id.edMax);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int minimo = Integer.parseInt(edMin.getText().toString());
                int maximo = Integer.parseInt(edMax.getText().toString());

                // Certifique-se de que minimo é menor que maximo
                if (minimo >= maximo) {
                    textView.setText("Valor mínimo deve ser menor que o valor máximo.");
                    return;
                }

                Random random = new Random();
                int valorSorteado = random.nextInt(maximo - minimo) + minimo; // Correção aqui
                textView.setText(Integer.toString(valorSorteado));
            }
        });
    }
}
