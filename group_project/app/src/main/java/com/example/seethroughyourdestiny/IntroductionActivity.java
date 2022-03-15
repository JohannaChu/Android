package com.example.seethroughyourdestiny;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroductionActivity extends AppCompatActivity {

    Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        startBtn = (Button) findViewById(R.id.button5);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(IntroductionActivity.this,ProcessActivity.class);
                startActivity(intent);
            }
        });
    }
}