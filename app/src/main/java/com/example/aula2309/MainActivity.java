package com.example.aula2309;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ciclo de vida", "onCreate");
        Button button = findViewById(R.id.button);
        ed =findViewById(R.id.ed);

        ed.setText("asdfhawuighfiu");
        ed.setText("a");



    }
    public void onClick(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivityB.class);
        String s=ed.getText().toString();
        i.putExtra("msg",s );
        startActivity(i);
        Log.d("asdfgh","click");
    }


    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
        Log.d("ciclo de vida", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        setContentView(R.layout.activity_main);
        Log.d("ciclo de vida", "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        Log.d("ciclo de vida", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        setContentView(R.layout.activity_main);
        Log.d("ciclo de vida", "onPause");
    }
}