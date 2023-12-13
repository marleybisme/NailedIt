package com.example.nailedit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NailHub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nail_hub);
        Button quiz = findViewById(R.id.btHubQuiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NailHub.this, IntroQuiz.class));
            }
        });
        Button tip = findViewById(R.id.btHubTip);
        tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NailHub.this, TipCalc.class));
            }
        });

        Button pinterest = findViewById(R.id.btHubInspo);
        pinterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://pinterest.com")));
            }
        });

        Button bookset = findViewById(R.id.btHubBook);
        bookset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://coatedbyji.as.me/schedule.php")));
            }
        });
    }


}