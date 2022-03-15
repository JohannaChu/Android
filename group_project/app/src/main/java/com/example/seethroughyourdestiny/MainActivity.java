package com.example.seethroughyourdestiny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Button1;
    Button Button2;
    Button Button3;
    Button Button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button1 = (Button) findViewById(R.id.button);
        Button2 = (Button) findViewById(R.id.button2);
        Button3 = (Button) findViewById(R.id.button3);
        Button4 = (Button) findViewById(R.id.button4);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,IntroductionActivity.class);
                startActivity(intent);
            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,IntroductionActivity.class);
                startActivity(intent);
            }
        });
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,IntroductionActivity.class);
                startActivity(intent);
            }
        });
        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,IntroductionActivity.class);
                startActivity(intent);
            }
        });
    }
}