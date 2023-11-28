package com.example.nailedit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class TipCalc extends AppCompatActivity {
    double percentint;
    double setCostint;
    double totalCost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calc);
        final EditText setCost = (EditText) findViewById(R.id.tvPrice);
        final EditText percent = (EditText) findViewById(R.id.tvPercent);
        Button calculate = findViewById(R.id.btCalc);
        calculate.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView) findViewById(R.id.tvResult));

            @Override
            public void onClick(View view) {
                percentint = Integer.parseInt(percent.getText().toString());
                setCostint = Integer.parseInt(setCost.getText().toString());
                totalCost = (percentint / 100) * setCostint;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                result.setText("Tip amount: " + currency.format(totalCost));
            }
        });
    }}