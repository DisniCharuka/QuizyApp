package com.example.disni.quizy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnQuiz1;
    Button btnQuiz2;
    Button btnQuiz3;
    Button btnQuiz4;
    Button btnQuiz5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClick();
    }

    private void buttonClick() {
        btnQuiz1 = (Button) findViewById(R.id.btnQuiz1);
        btnQuiz2 = (Button) findViewById(R.id.btnQuiz2);
        btnQuiz3 = (Button) findViewById(R.id.btnQuiz3);
        btnQuiz4 = (Button) findViewById(R.id.btnQuiz4);
        btnQuiz5 = (Button) findViewById(R.id.btnQuiz5);

        btnQuiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Quiz1.class);
                startActivity(intent);
            }
        });

        btnQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Quiz2.class);
                startActivity(intent);
            }
        });

        btnQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Quiz3.class);
                startActivity(intent);
            }
        });

        btnQuiz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Quiz4.class);
                startActivity(intent);
            }
        });

        btnQuiz5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Quiz5.class);
                startActivity(intent);
            }
        });
    }
}
