package com.example.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText edtYear;
    TextView txtMessage;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtYear = findViewById(R.id.editText);
        txtMessage = findViewById(R.id.textView);
    }

    public void calculate(View view) {

        int birthYear = Integer.parseInt(edtYear.getText().toString());
        int currentYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));

        if (!edtYear.getText().toString().isEmpty() && (birthYear <= currentYear)) {
            //txtMessage.setText("You are " + (currentYear - birthYear) + " years old");
            txtMessage.setText(getResources().getString(R.string.message, (currentYear - birthYear)));
        } else {
            //Toast.makeText(this, "Please add a valid year", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, getResources().getString(R.string.error1), Toast.LENGTH_SHORT).show();
        }
    }
}