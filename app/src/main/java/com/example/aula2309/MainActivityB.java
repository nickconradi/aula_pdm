package com.example.aula2309;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);
       Button b= findViewById(R.id.button2);
       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });
       Bundle bundle = getIntent().getExtras();
       String msg = bundle.getString("msg");

        TextView textView = findViewById(R.id.textView);
        textView.setText(msg);
    }
}