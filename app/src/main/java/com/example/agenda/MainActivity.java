package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Identification et déclaration des éléments du layout
    EditText et_name, et_surname, et_adress, et_cp, et_city, et_phone, et_gender, et_birthday, et_place;
    Button btn_valid, btn_viewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.et_name);
        et_surname = findViewById(R.id.et_surname);
        et_adress = findViewById(R.id.et_adress);
        et_cp = findViewById(R.id.et_cp);
        et_city = findViewById(R.id.et_city);
        et_phone = findViewById(R.id.et_phone);
        et_gender = findViewById(R.id.et_gender);
        et_birthday = findViewById(R.id.et_birthday);
        et_place = findViewById(R.id.et_place);
        btn_valid = findViewById(R.id.btn_valid);
        btn_viewAll = findViewById(R.id.btn_viewAll);


        // bouton 'Valider' listener
        btn_valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AgendaModel agendaModel;
                try {
                    agendaModel = new AgendaModel(666, et_name.getText().toString(), et_surname.getText().toString(), et_adress.getText().toString(), Integer.parseInt(et_cp.getText().toString()), et_city.getText().toString(), Integer.parseInt(et_phone.getText().toString()), et_gender.getText().toString(), et_birthday.getText().toString(), et_place.getText().toString());
                    Toast.makeText(MainActivity.this, agendaModel.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Erreur de saisie", Toast.LENGTH_SHORT).show();
                    agendaModel = new AgendaModel(-1, "error", "error", "error", 0, "error", 0, "e", "error", "error");
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                boolean success = dataBaseHelper.addOne(agendaModel);
                if (success == true) {
                    Toast.makeText(MainActivity.this, "Great success !", Toast.LENGTH_SHORT).show(); // cela s'affiche même si il n'y a pas d'entrées
                }
            }
        });

        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "fdp", Toast.LENGTH_SHORT).show();
            }
        });
    }

}