package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    EditText editTextNome, editTextEmail, editTextData;
    Button button;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Associar variaveis locais a views da interface
        editTextNome = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextData = findViewById(R.id.editTextData);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);


        //definindo tratamento para evento de click do botao
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                // database.execSQL("INSERT INTO (nom,email) VALUES(\""+nome+"\")");
                ContentValues cv = new ContentValues();
                cv.put("nome", nome);
                cv.put("email", email);
                long status = database.insert("pessoas", null, cv);
                if (status > 0) {
                    Toast.makeText(getApplicationContext(), "Usuário inserido com sucesso!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Erro na inserção!", Toast.LENGTH_LONG).show();
                }
                carregarListagem();
            }


        });

        database = openOrCreateDatabase("meubd", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR,email varchar, datanasc base)");
        carregarListagem();


    }

    public void carregarListagem(){
        Cursor cursor = database.rawQuery("SELECT * FROM pessoas ", null);
        cursor.moveToFirst();
        ArrayList<String> nomes = new ArrayList<>();
        while (!cursor.isAfterLast()){
            nomes.add(cursor.getString(1));
            cursor.moveToNext();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, nomes);
        listView.setAdapter(adapter);
    }


    public void limparCampos() {
        editTextNome.setText("");
        editTextEmail.setText("");
        editTextData.setText("");
    }
}