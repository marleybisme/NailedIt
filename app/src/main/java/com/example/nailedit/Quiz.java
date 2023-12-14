package com.example.nailedit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HexFormat;

public class Quiz extends AppCompatActivity implements View.OnClickListener{
    Button ansA, ansB, ansC, ansD;
    TextView questiontv;
    Button submitbt;

    int score = 0;
    int totalq = 6;
    int currentq = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questiontv = findViewById(R.id.question);
        ansA = findViewById(R.id.btq1);
        ansB = findViewById(R.id.btq2);
        ansC = findViewById(R.id.btq3);
        ansD = findViewById(R.id.btq4);
        submitbt = findViewById(R.id.btsubmit);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitbt.setOnClickListener(this);

        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.parseColor("#673AB7"));
        ansB.setBackgroundColor(Color.parseColor("#673AB7"));
        ansC.setBackgroundColor(Color.parseColor("#673AB7"));
        ansD.setBackgroundColor(Color.parseColor("#673AB7"));

        Button clicked = (Button) view;
        if(clicked.getId()==R.id.btsubmit){

            if(selectedAnswer.equals(QuizQuestions.answers[currentq][0])){
                score += 0;
            }
            if(selectedAnswer.equals(QuizQuestions.answers[currentq][1])){
                score += 2;
            }
            if(selectedAnswer.equals(QuizQuestions.answers[currentq][2])){
                score += 4;
            }
            if(selectedAnswer.equals(QuizQuestions.answers[currentq][3])){
                score += 6;
            }
            currentq++;
            loadNewQuestion();
        } else {
            selectedAnswer = clicked.getText().toString();
            clicked.setBackgroundColor(Color.parseColor("#85DBD9"));
        }
    }

    void loadNewQuestion(){
        if(currentq == 6){
            finishQuiz();
            return;
        }
        questiontv.setText(QuizQuestions.question[currentq]);
        ansA.setText(QuizQuestions.answers[currentq][0]);
        ansB.setText(QuizQuestions.answers[currentq][1]);
        ansC.setText(QuizQuestions.answers[currentq][2]);
        ansD.setText(QuizQuestions.answers[currentq][3]);
    }

    void finishQuiz(){
        final MediaPlayer rico = MediaPlayer.create(Quiz.this, R.raw.rico);
        final MediaPlayer megan = MediaPlayer.create(Quiz.this, R.raw.megan);
        final MediaPlayer halle = MediaPlayer.create(Quiz.this, R.raw.halle);
        final MediaPlayer etta = MediaPlayer.create(Quiz.this, R.raw.etta);

        String style = "";
        if(score <= 9 ){
            style = "Your nail style is 3D Metallic Duck Nails!";
            rico.start();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (rico.isPlaying()) {
                        rico.stop();
                    }
                    rico.release();
                }
            }, 10000);
        }
        if(score > 9 && score <= 18 ){
            style = "Your nail style is Neon Glitter Coffin Nails!";
            megan.start();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (megan.isPlaying()) {
                        megan.stop();
                    }
                    megan.release();
                }
            }, 10000);
        }
        if(score > 18 && score <= 27 ){
            style = "Your nail style is Matte Nude Square Nails!";
            halle.start();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (halle.isPlaying()) {
                        halle.stop();
                    }
                    halle.release();
                }
            }, 10000);
        }
        if(score >= 28){
            style = "Your nail style is Dainty Glossy Almond Nails!";
            etta.start();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (etta.isPlaying()) {
                        etta.stop();
                    }
                    etta.release();
                }
            }, 10000);
        }

        new AlertDialog.Builder(this)
                .setTitle("Results")
                .setMessage(style)
                .setPositiveButton("Back to Nail Hub", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();

        final SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("key1", style);
        editor.commit();
    }

    void restartQuiz(){
        startActivity(new Intent(Quiz.this, NailHub.class));
    }
}